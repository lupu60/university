using UnityEngine;
using System.Collections;

[RequireComponent(typeof(AudioSource))]
public class PartyTime : MonoBehaviour {
	private GameObject player;		 
	public GameObject eff;
//	public GameObject light;
	public static bool dancing = false;
	// Use this for initialization

	void Awake ()
	{	
		// Setting up the references.
		player = GameObject.FindGameObjectWithTag (DoneTags.player);
		dancing = false;
	}
	void Start () {

	}
	
	// Update is called once per frame
	void Update () {
		if (Input.GetKeyDown(KeyCode.P)) {
			dancing = false;
		}
	}
	void OnTriggerEnter (Collider other)
	{	
		// If the colliding gameobject is the player...
		if(other.gameObject == player)
		{	eff.SetActive(true);
			// ... play the clip at the position of the key...
			audio.Play();
			ManagerTimeScore.score+=100;
			dancing = true;
		}
	}

	void OnTriggerExit(Collider other) {

		if(other.gameObject == player)
		{	eff.SetActive(false);
			audio.Stop();
			dancing = false;
		}
	}
}
