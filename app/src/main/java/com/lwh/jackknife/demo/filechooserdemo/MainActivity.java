package com.lwh.jackknife.demo.filechooserdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lwh.jackknife.fileexplorer.FileChooser;
import com.lwh.jackknife.fileexplorer.ui.FileExplorerActivity;

public class MainActivity extends AppCompatActivity {

    private Button btn_choose_file;
    private TextView tv_main_path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_choose_file = findViewById(R.id.btn_choose_file);
        btn_choose_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileChooser.chooseFileAndFolder(MainActivity.this);
            }
        });
        tv_main_path = findViewById(R.id.tv_main_path);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == FileChooser.REQUEST_CODE_CHOOSE_BOTH_FILE_AND_FOLDER) {
                String path = data.getStringExtra("path");
                tv_main_path.setText("选择路径:"+path);
            }
        }
    }
}
