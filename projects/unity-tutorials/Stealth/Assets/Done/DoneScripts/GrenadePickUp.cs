using UnityEngine;
using System.Collections;

public class GrenadePickUp : MonoBehaviour {
	public AudioClip keyGrab;		
	private GameObject player;		
	// Use this for initialization
	void Awake ()
	{
		// Setting up the references.
		player = GameObject.FindGameObjectWithTag (DoneTags.player);
	}
	void Start () {
	
	}
	
	// Update is called once per frame
	void Update () {
	
	}

	void OnTriggerEnter (Collider other)
	{
		// If the colliding gameobject is the player...
		if(other.gameObject == player)
		{
			// ... play the clip at the position of the key...
			AudioSource.PlayClipAtPoint(keyGrab, transform.position);
			ManagerTimeScore.score+=50;
			ManagerTimeScore.grenade+=1;
			// ... and destroy this gameobject.
			Destroy(gameObject);
		}
	}
}
