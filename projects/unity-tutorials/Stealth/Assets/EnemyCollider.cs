using UnityEngine;
using System.Collections;

public class EnemyCollider : MonoBehaviour {
	public GameObject ethan;	
	// Use this for initialization
	void Start () {
	
	}
	
	// Update is called once per frame
	void Update () {
	
	}
	void OnTriggerEnter (Collider other)
	{	
		// If the colliding gameobject is the player...
		if(other.gameObject == ethan)
		{	
			ManagerTimeScore.score-=100;
		}
	}
}
