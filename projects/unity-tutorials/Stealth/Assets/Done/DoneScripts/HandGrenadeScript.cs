using UnityEngine;
using System.Collections;

public class HandGrenadeScript : MonoBehaviour {
	public GameObject grenade;
	public GameObject burst;
	public GameObject handgrenade;
	// Use this for initialization
	void Start () {
		StartCoroutine(UpdateTime());
	}
	
	// Update is called once per frame
	void Update () {
	
	}
	IEnumerator UpdateTime()
	{
		while(true)
		{ 	
			yield return new WaitForSeconds(5);
			grenade.SetActive(false);
			burst.SetActive(true);
			yield return new WaitForSeconds(1);
			Destroy(handgrenade);
			FindTheBall.publicspeed = 0;
		}
	}
}
