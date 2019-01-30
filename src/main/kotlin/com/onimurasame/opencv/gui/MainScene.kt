package com.onimurasame.opencv.gui

import javafx.scene.Parent
import javafx.scene.Scene
import org.springframework.stereotype.Component

@Component
class MainScene: Scene {

    constructor(parent: Parent): super(parent, 800.0, 600.0)

}