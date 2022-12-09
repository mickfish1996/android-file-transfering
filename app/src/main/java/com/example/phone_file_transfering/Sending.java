package com.example.phone_file_transfering;



import static androidx.activity.result.ActivityResultCallerKt.registerForActivityResult;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import java.net.*;
import java.io.*;
import java.util.*;


public class Sending{
    private Socket sock;
    private ServerSocket serverSock;
    private static int port = 6066;


    public void startServer(File selected) throws IOException
    {
        Send send;

        serverSock = new ServerSocket(port);

        sock = serverSock.accept();



        BufferedOutputStream out = new BufferedOutputStream(sock.getOutputStream());
        FileInputStream fis = new FileInputStream(selected);
        BufferedInputStream bis = new BufferedInputStream(fis);
        int n = -1;

        byte[] buffer;

        buffer = new byte[70022386];

        while((n = bis.read(buffer)) > -1)
        {
            out.write(buffer, 0, n);
            out.flush();
        }

        serverSock.close();
    }

    public void start(File file) throws IOException
    {
        startServer(file);
    }


}
