package de.hsrm.cs.wwwvs.p3.cli;

import de.hsrm.cs.wwwvs.p3.Directory;
import de.hsrm.cs.wwwvs.p3.File;
import de.hsrm.cs.wwwvs.p3.Filesystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Einfacher CLI Client für RMI-Aufgabe
 * 
 * @author Andreas Textor
 */
public class ClientCLI {
	private static Filesystem fs;
	private static Directory current;

	private interface ArgRunnable {
		void run(String arg) throws Throwable;
	}
	
	enum Command {
		ls("Listet Dateien und Verzeichnisse", new ArgRunnable() {
			public void run(String arg) throws Throwable {
				final Directory c = ClientCLI.current;
				for (Directory d: c.listDirectories()) {
					int items = d.listDirectories().size() + d.listFiles().size();
					System.out.printf("drw-r--r- %4d %s\n", items, d.getName());
				}
				for (File f: c.listFiles()) {
					System.out.printf(" rw-r--r- %4d %s\n", f.getLength(), f.getName());
				}
			}
		}),
		pwd("Gibt das aktuelle Verzeichnis aus", new ArgRunnable() {
			public void run(String arg) throws Throwable {
				System.out.println(ClientCLI.current.getFullPath());
			}
		}),
		mkdir("Legt ein neues Verzeichnis an", new ArgRunnable() {
			public void run(String arg) throws Throwable {
				ClientCLI.current.createDirectory(arg);
			}
		}),
		touch("Legt eine neue Datei an", new ArgRunnable() {
			public void run(String arg) throws Throwable {
				ClientCLI.current.createFile(arg);
			}
		}),
		cd("Wechselt in ein Verzeichnis", new ArgRunnable() {
			public void run(String arg) throws Throwable {
				if (arg == null) {
					current = fs.getRoot();
				} else {
					final Directory d = current.getDirectory(arg);
					if (d == null) {
						System.out.printf("Verzeichnis nicht gefunden: %s\n", arg);
					} else {
						current = d;
					}
				}
			}
		}),
		cat("Gibt den Inhalt einer Datei aus", new ArgRunnable() {
			public void run(String arg) throws Throwable {
				final File f = ClientCLI.current.getFile(arg);
				if (f == null) {
					System.out.printf("Datei nicht gefunden: %s\n", arg);
				} else {
					byte[] b = f.read(0, f.getLength());
					System.out.println(new String(b));
				}
			}
		}),
		edit("Editiert eine Datei an einem Offset. Nutzung: edit datei offset inhalt, z.B.: edit foo 0 Hallo Welt", new ArgRunnable() {
			public void run(String arg) throws Throwable {
				final String[] a = arg.split(" ", 3);
				final String filename = a[0];
				final int offset = Integer.parseInt(a[1]);
				final String content = a[2];
				final File f = ClientCLI.current.getFile(filename);

				if (f == null) {
					System.out.printf("Datei nicht gefunden: %s\n", filename);
				} else {
					f.write(offset, content.getBytes());
				}
			}
		}),
		echo("Schreibt in eine Datei. Nutzung: echo datei inhalt, z.B.: echo foo Hallo Welt", new ArgRunnable() {
			public void run(String arg) throws Throwable {
				final String[] a = arg.split(" ", 2);
				if (a == null || a.length < 2) {
					System.out.println(Command.echo.helpString);
					return;
				}
				
				final String fileName = a[0];
				File f = ClientCLI.current.getFile(fileName);
				if (f == null) {
					ClientCLI.current.createFile(fileName);
					f = ClientCLI.current.getFile(fileName);
				}
				
				f.write(0, a[1].getBytes());
			}
		}),
		rm("Löscht eine Datei", new ArgRunnable() {
			public void run(String arg) throws Throwable {
				ClientCLI.current.deleteFile(arg);
			}
		}),
		rmdir("Löscht ein Verzeichnis", new ArgRunnable() {
			public void run(String arg) throws Throwable {
				ClientCLI.current.deleteDirectory(arg);
			}
		}),
		help("Gibt die möglichen Befehle aus", new ArgRunnable() {
			public void run(String arg) {
				for (Command c: Command.values()) {
					System.out.printf("%10s - %s\n", c, c.helpString);
				}
			}
		});

		private String helpString;
		private ArgRunnable runner;
		
		Command(final String helpString, final ArgRunnable runner) {
			this.helpString = helpString;
			this.runner = runner;
		}
		
		void run(final String arg) {
			try {
				this.runner.run(arg);
			} catch (final Throwable t) {
				System.out.printf("Fehler beim Ausführen von Kommando %s: %s: %s\n", this, t.getClass().getSimpleName(), t.getMessage());
			}
		}
	}
	
	public ClientCLI(final Filesystem filesystem) {
		fs = filesystem;
		try {
			current = fs.getRoot();
		} catch (Throwable t) {
			System.out.println("Konnte Wurzelverzeichnis nicht lesen");
			t.printStackTrace();
			return;
		}

		final BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
		
		for(;;) {
			try {
				System.out.printf("%s > ", current.getFullPath());
			} catch (Throwable t) {
				System.out.printf("<ERROR: %s> >", t.getMessage());
			}

			String s;

			try {
				s = d.readLine();
			} catch (IOException e) {
				System.out.println("Fehler bei Eingabe");
				return;
			}
			
			Command cmd;
			String arg;
			try {
				final String[] inp = s.split(" ", 2);
				cmd = Command.valueOf(inp[0]);
				arg = inp.length > 1 ? inp[1] : null;
			} catch (Exception e) {
				System.out.println("Ungültiger Befehl.");
				Command.help.run(null);
				continue;
			}
			
			try {
				cmd.run(arg);
			} catch (Throwable t) {
				System.out.printf("Fehler bei Aufruf von Befehl: %s: %s: %s\n", arg, t.getClass().getSimpleName(), t.getMessage());
			}
		}
	}
}
