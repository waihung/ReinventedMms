package com.android.mms.reinvented.mms.fragments.request;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.mms.R;

public class RequestByEmail extends Fragment {

	private EditText recipient;
	private EditText subject;
	private EditText body;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View view = inflater
				.inflate(R.layout.request, container, false);

		recipient = (EditText) view.findViewById(R.id.recipient);
		subject = (EditText) view.findViewById(R.id.subject);
		body = (EditText) view.findViewById(R.id.body);

		Button sendBtn = (Button) view.findViewById(R.id.sendEmail);
		sendBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				sendEmail();
				// after sending the email, clear the fields
				recipient.setText("MBQSniper@hotmail.com");
				subject.setText("Feature Request");
				body.setText("");
			}
		});
		return view;

	}

	protected void sendEmail() {

		String[] recipients = { recipient.getText().toString() };
		Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
		// prompts email clients only
		email.setType("message/rfc822");

		email.putExtra(Intent.EXTRA_EMAIL, recipients);
		email.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
		email.putExtra(Intent.EXTRA_TEXT, body.getText().toString());

		try {
			// the user can choose the email client
			startActivity(Intent.createChooser(email,
					"Choose an email client from..."));

		} catch (android.content.ActivityNotFoundException ex) {
			Toast.makeText(getActivity(), "No email client installed.",
					Toast.LENGTH_LONG).show();
		}
	}

}
