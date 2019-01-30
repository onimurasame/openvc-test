package com.onimurasame.opencv.gui

import javafx.scene.layout.GridPane
import org.springframework.stereotype.Component

@Component
class LayoutGridPane: GridPane {

    constructor() {
        this.height = 600.0
        this.width = 800.0
        this.isGridLinesVisible = true
        this.style = """
            -fx-background-color: YELLOW
        """.trimIndent()
    }

}