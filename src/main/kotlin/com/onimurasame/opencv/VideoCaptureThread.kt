package com.onimurasame.opencv

class VideoCaptureThread : Runnable {

    override fun run() {
        println("${Thread.currentThread()} running")
    }


}