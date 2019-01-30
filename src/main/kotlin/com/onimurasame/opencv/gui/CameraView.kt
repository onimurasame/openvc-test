package com.onimurasame.opencv.gui

import javafx.application.Platform
import javafx.beans.property.ObjectProperty
import javafx.embed.swing.SwingFXUtils
import javafx.scene.image.ImageView
import org.opencv.core.Mat
import org.opencv.imgproc.Imgproc
import org.opencv.videoio.VideoCapture
import java.awt.image.BufferedImage
import java.awt.image.DataBufferByte
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit


object CameraView {

    val imageView: ImageView = ImageView()

    private val videoCapture: VideoCapture = VideoCapture()
    private val timer: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
    private var cameraActive = false

    fun startCamera() {
        if (!this.cameraActive) {
            this.videoCapture.open(0)

            if (this.videoCapture.isOpened) {
                this.cameraActive = true
                val frameGrabber = Runnable {

                    fun run() {
                        val frame: Mat = grabFrame(this.videoCapture)
                        val image = SwingFXUtils.toFXImage(mat2BufferedImage(frame), null)
                        onFXThread(imageView.imageProperty(), image)
                    }
                }

                this.timer.scheduleAtFixedRate(frameGrabber, 0, 33, TimeUnit.MILLISECONDS)

                // TODO Expose this as a method
                CameraStartButton.text = "Stop Camera"

            } else {
                println("Couldn't connect to camera....")
            }
        } else {
            this.cameraActive = false
            // TODO Expose this as a method
            CameraStartButton.text = "Start Camera"
            stopAcquisition()

        }
    }

    private fun grabFrame(videoCapture: VideoCapture): Mat {
        val frame = Mat()

        if (videoCapture.isOpened) {
            try {
                videoCapture.read(frame)

                if (!frame.empty()) {
                    Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2GRAY)
                }

            } catch (e: Exception) {
                println("Error: ${e.message}")
                e.printStackTrace()
            }
        }

        return frame

    }

    private fun <T : Any> onFXThread(property: ObjectProperty<T>, value: T) {
        Platform.runLater {
            property.setValue(value)
        }
    }

    private fun mat2BufferedImage(mat: Mat): BufferedImage {
        val bufferedImage: BufferedImage
        val width = mat.width()
        val height = mat.height()
        val pixels = byteArrayOf()

        mat.get(0, 0, pixels)

        if (mat.channels() > 1) {
            bufferedImage = BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR)
        } else {
            bufferedImage = BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY)
        }

        val targetPixels = (bufferedImage.raster.dataBuffer as DataBufferByte).data
        System.arraycopy(pixels, 0, targetPixels, 0, pixels.size)

        return bufferedImage

    }

    private fun stopAcquisition() {
        if (!this.timer.isShutdown) {
            try {
                this.timer.shutdown()
                this.timer.awaitTermination(33, TimeUnit.MILLISECONDS)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }

        if (this.videoCapture.isOpened) {
            this.videoCapture.release()
        }
    }

}