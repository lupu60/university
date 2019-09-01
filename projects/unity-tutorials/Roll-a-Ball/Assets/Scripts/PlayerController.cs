using UnityEngine;
using System.Collections;
using UnityEngine.UI;

public class PlayerController : MonoBehaviour {
	public float speed;
	private int count;
	public Text countText;
	public Text winText;
	// Use this for initialization
	void Start () {
		count = 0;	
		SetCountText ();
		winText.text = "";

	}
	
	// Update is called once per frame
	void Update () {
	
	}
	void FixedUpdate(){
		float moveHorizontal = Input.GetAxis ("Horizontal");
		float moveVertical = Input.GetAxis ("Vertical");
		Vector3 movement = new Vector3 (moveHorizontal, 0.0f, moveVertical);
		GetComponent<Rigidbody>().AddForce (movement * speed *Time.deltaTime); 
	}
	void OnTriggerEnter(Collider other) {
		if (other.gameObject.tag == "PickUp") {
			count++;
			other.gameObject.SetActive(false);
			SetCountText ();
		}
	}
	void SetCountText(){
		countText.text = "Count  " + count.ToString ();
		if (count >= 14) {
			winText.text = "YOU WIN!";
		}
	}
}