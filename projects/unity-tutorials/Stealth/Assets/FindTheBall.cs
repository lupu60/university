using UnityEngine;
using System.Collections;

public class FindTheBall : MonoBehaviour {
	public Transform target;
	public  float speed;
	public static float publicspeed;

	void Awake()
	{


	}
	// Use this for initialization
	void Start () {

	}
	
	// Update is called once per frame
	void Update () {
			speed = publicspeed;
			float step = speed * Time.deltaTime;
			transform.position = Vector3.MoveTowards (transform.position, target.position, step);
	}
}
