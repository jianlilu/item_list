package com.example.lu.me_lu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MyHello extends Activity {

//   final static  EditText text;
   StringBuilder stringBuilder = new StringBuilder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world);

//        initView();
    }


    /** 组件初始化 */
    private void initView() {
//        text = (EditText) findViewById(R.id.edtext);

    }

    /** 获取EditText上用户输入的内容 */
//    public String getText() {
//       String s = text.getText().toString();
//        text.setText("");
//       return s;
//    }

    /** 添加标注按钮点击事件 */
    public void myNote(View v) {
        myDialog();

    }
    /** 查看标注列表按钮点击事件 */
    public void myNoteList(View v) {
        toMyIntent();
    }


/** 弹出对话框 */
    private void myDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(MyHello.this);
        View promptView = layoutInflater.inflate(R.layout.annotation_cfg, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MyHello.this);

        alertDialogBuilder.setView(promptView);


        final EditText text    = (EditText) promptView.findViewById(R.id.name_edit);
        final EditText height_edit  = (EditText) promptView.findViewById(R.id.height_edit);

//        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                try {
                    if (text.getText().length() == 0)
                        throw new Exception("标注名不能为空");

                    if (text.getText().length() > 0) {

                        String str = text.getText() + "#";

                        String s = stringBuilder.append(str).toString();


                        setMyText(s);

//                        Toast.makeText(getApplicationContext(), "stringBuilder == " + s, Toast.LENGTH_LONG).show();

                    }
                }catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "高度必须是数字类型", Toast.LENGTH_LONG).show();
//                            Toast.makeText(context, "Height must be a number; discarding...", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "ee - - " + e.getMessage()+ " - - ee", Toast.LENGTH_LONG).show();
                } finally {

                }
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        final AlertDialog alertDlg = alertDialogBuilder.create();
        alertDlg.show();

    }

    /** 跳转至另一个Activity页面 */
    private void toMyIntent() {
        Intent intent = new Intent();
        intent.setClass(MyHello.this, MyHelloTo.class);
        startActivity(intent);

    }


    static String myString;

/** 保存EditText里取得的数据 */
    public void setMyText(String string) {
        myString = string;
    }

    public String getMyText( ) {
        Log.e("myLog", "getMyText() run ##### ");
        Log.e("myLog"," myString === " + myString);
//        return getData(context);

        if (myString != null)
            return myString;
        else {
            return "myString was null";
        }

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)
        {
            // 创建退出对话框
            AlertDialog isExit = new AlertDialog.Builder(this).create();
            // 设置对话框标题
            isExit.setTitle("系统提示");
            // 设置对话框消息
            isExit.setMessage("确定要退出吗");
            // 添加选择按钮并注册监听
            isExit.setButton("确定", listener);
            isExit.setButton2("取消", listener);
            // 显示对话框
            isExit.show();
        }

        return false;

    }

    /**监听对话框里面的button点击事件*/
    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener()
    {
        public void onClick(DialogInterface dialog, int which)
        {
            switch (which)
            {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
                    finish();
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
                default:
                    break;
            }
        }
    };



}
