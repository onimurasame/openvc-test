package com.onimurasame.opencv.gui

import javafx.scene.image.ImageView
import org.opencv.videoio.VideoCapture
import org.springframework.stereotype.Component

@Component
class CameraView: ImageView {

    val videoCapture: VideoCapture = VideoCapture(0)

    constructor() {

    }

}