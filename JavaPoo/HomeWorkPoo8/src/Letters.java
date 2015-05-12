
//		Path file for work Paths
//				.get("c:\\Users\\work\\Dropbox\\workspace\\HomeWorkPoo8\\template.txt");

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;

public class Letters
{

	 	public static void main(String[] args)
	{

		Path p = Paths.get("/home/wolf/Dropbox/workspace/HomeWorkPoo8/template.txt");
		ArrayList<String> template = null;
		try
		{
			template = (ArrayList<String>) Files.readAllLines(p,
					Charset.defaultCharset());
		} catch (IOException e)
		{

			e.printStackTrace();
		}
		p = Paths.get("/home/wolf/Dropbox/workspace/HomeWorkPoo8/names.txt");
		ArrayList<String> names = null;
		try
		{
			names = (ArrayList<String>) Files.readAllLines(p,
					Charset.defaultCharset());
		} catch (IOException e)
		{

			e.printStackTrace();
		}
		for (String string : names)
		{
			String original = template.get(0);
			String str1 = template.get(0) + " " + string;
			template.remove(0);
			template.add(0,str1);
			p = Paths.get("/home/wolf/Dropbox/workspace/HomeWorkPoo8/" + string
					+ "_temp.txt");
			try
			{
				Files.write(p, template, Charset.defaultCharset());
			} catch (IOException e)
			{

				e.printStackTrace();
			}
			template.remove(0);
			template.add(0, original);

		}

	}

}
