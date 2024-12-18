import com.huskerdev.openglfx.canvas.GLCanvas
import com.huskerdev.openglfx.lwjgl.LWJGLExecutor
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import scene.ExampleScene


class App: Application() {

    override fun start(stage: Stage) {
        stage.title = "openglfx example"
        stage.width = 800.0
        stage.height = 600.0
        stage.scene = Scene(createGLCanvas())
        stage.show()
    }

    private fun createGLCanvas(): GLCanvas{
        val canvas = GLCanvas(LWJGLExecutor.LWJGL_MODULE)

        val renderExample = ExampleScene()
        canvas.addOnInitEvent(renderExample::init)
        canvas.addOnReshapeEvent(renderExample::reshape)
        canvas.addOnRenderEvent(renderExample::render)

        return canvas
    }
}