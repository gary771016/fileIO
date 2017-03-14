package com.example.mrcat.lesson_062;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private Button btn1, btn2, btn3,btn4;
    private static final String FILE_NAME = "fileIO.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);

        btn1.setOnClickListener(btn1L);
        btn2.setOnClickListener(btn2L);
        btn3.setOnClickListener(btn3L);
        btn4.setOnClickListener(btn4L);


    }

    private View.OnClickListener btn1L = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                FileOutputStream fileOutputStream = openFileOutput(FILE_NAME, MODE_APPEND);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                bufferedOutputStream.write(et1.getText().toString().getBytes());
                bufferedOutputStream.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    private View.OnClickListener btn2L = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                FileInputStream fileInputStream = openFileInput(FILE_NAME);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

                byte[] buffBytes = new byte[10];

                et2.setText("");
                do {
                    int c = bufferedInputStream.read(buffBytes);
                    if (c == -1)
                        break;
                    else
                        et2.append(new String(buffBytes), 0, c);

                } while (true);
                bufferedInputStream.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    private View.OnClickListener btn3L = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FileOutputStream fileOutputStream = null;


            try {
                fileOutputStream = openFileOutput(FILE_NAME, MODE_PRIVATE);
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    };

    private View.OnClickListener btn4L=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                FileWriter fileWriter=new FileWriter("/sdcard/output.txt",false);
                BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
                bufferedWriter.write(et1.getText().toString());
                bufferedWriter.newLine();
                bufferedWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

}
