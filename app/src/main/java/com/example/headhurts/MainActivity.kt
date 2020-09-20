package com.example.headhurts

import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode
import com.google.ar.sceneform.assets.RenderableSource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var arrayView: Array<View>

    lateinit var arFragment: ArFragment

    lateinit var plantRenderable1: ModelRenderable
    lateinit var plantRenderable2: ModelRenderable
    lateinit var plantRenderable3: ModelRenderable
    lateinit var plantRenderable4: ModelRenderable
    lateinit var plantRenderable5: ModelRenderable
    lateinit var vitaminRenderable: ModelRenderable

    internal var selected = 1


    override fun onClick(view: View?) {
        if (view!!.id == R.id.plant1) {
            selected = 1
            mySetBackground(view!!.id)
        }
        else if (view!!.id == R.id.plant2) {
            selected = 2
            mySetBackground(view!!.id)
        }

        else if (view!!.id == R.id.plant3) {
            selected = 3
            mySetBackground(view!!.id)
        }

        else if (view!!.id == R.id.plant4) {
            selected = 4
            mySetBackground(view!!.id)
        }

        else if (view!!.id == R.id.plant5) {
            selected = 5
            mySetBackground(view!!.id)
        }

        else if (view!!.id == R.id.vitamin) {
            selected = 6
            mySetBackground(view!!.id)
        }


    }

    private fun mySetBackground(id: Int) {
        for( i in arrayView.indices) {
            if(arrayView[i].id == id)
                arrayView[i].setBackgroundColor(Color.parseColor("#80333639"))
            else
                arrayView[i].setBackgroundColor(Color.TRANSPARENT)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupArray()
        setupClickListener()
        setupModel()

        arFragment = supportFragmentManager.findFragmentById(R.id.sceneform_fragment) as ArFragment

        arFragment.setOnTapArPlaneListener { hitResult, plane, motionEvent ->
            val anchor = hitResult.createAnchor()
            val anchorNode = AnchorNode(anchor)
            anchorNode.setParent(arFragment.arSceneView.scene)

            createModel(anchorNode, selected)

        }


    }

    private fun createModel(anchorNode: AnchorNode, selected: Int) {
        if(selected == 1) {
            val plant1 = TransformableNode(arFragment.transformationSystem)
            plant1.setParent(anchorNode)
            plant1.renderable = plantRenderable1
            plant1.select()
        }
        else if(selected == 2) {
            val plant2 = TransformableNode(arFragment.transformationSystem)
            plant2.setParent(anchorNode)
            plant2.renderable = plantRenderable2
            plant2.select()
        }

        else if(selected == 3) {
            val plant3 = TransformableNode(arFragment.transformationSystem)
            plant3.setParent(anchorNode)
            plant3.renderable = plantRenderable3
            plant3.select()
        }

        else if(selected == 4) {
            val plant4 = TransformableNode(arFragment.transformationSystem)
            plant4.setParent(anchorNode)
            plant4.renderable = plantRenderable4
            plant4.select()
        }

        else if(selected == 5) {
            val plant5 = TransformableNode(arFragment.transformationSystem)
            plant5.setParent(anchorNode)
            plant5.renderable = plantRenderable5
            plant5.select()
        }

        else if(selected == 6) {
            val vitamin = TransformableNode(arFragment.transformationSystem)
            vitamin.setParent(anchorNode)
            vitamin.renderable = vitaminRenderable
            vitamin.select()
        }


    }

    private fun setupModel() {

        val modelUri = Uri.parse("UmbrellaPalmTree.gltf")
        val renderableFuture = ModelRenderable.builder()
            .setSource(
                this, RenderableSource.builder().setSource(
                    this,
                    modelUri,
                    RenderableSource.SourceType.GLTF2
                )
                    .setScale(0.08f)
                    .setRecenterMode(RenderableSource.RecenterMode.ROOT)
                    .build()
            )
            .setRegistryId("Plant1")
            .build()
        renderableFuture.thenAccept { plantRenderable1 = it }
        renderableFuture.exceptionally { _ ->
            Toast.makeText(this, "error loading renderablefuture ", Toast.LENGTH_LONG).show()
            null
        }

        val modelUri2 = Uri.parse("Houseplant.gltf")
        val renderableFuture2 = ModelRenderable.builder()
            .setSource(
                this, RenderableSource.builder().setSource(
                    this,
                    modelUri2,
                    RenderableSource.SourceType.GLTF2
                )
                    .setScale(0.08f)
                    .setRecenterMode(RenderableSource.RecenterMode.ROOT)
                    .build()
            )
            .setRegistryId("Plant2")
            .build()
        renderableFuture2.thenAccept { plantRenderable2 = it }
        renderableFuture2.exceptionally { _ ->
            Toast.makeText(this, "error loading renderablefuture ", Toast.LENGTH_LONG).show()
            null
        }

        val modelUri3 = Uri.parse("orchid.gltf")
        val renderableFuture3 = ModelRenderable.builder()
            .setSource(
                this, RenderableSource.builder().setSource(
                    this,
                    modelUri3,
                    RenderableSource.SourceType.GLTF2
                )
                    .setScale(0.08f)
                    .setRecenterMode(RenderableSource.RecenterMode.ROOT)
                    .build()
            )
            .setRegistryId("Plant3")
            .build()
        renderableFuture3.thenAccept { plantRenderable3 = it }
        renderableFuture3.exceptionally { _ ->
            Toast.makeText(this, "error loading renderablefuture ", Toast.LENGTH_LONG).show()
            null
        }


        val modelUri4 = Uri.parse("RubberFigPottedPlant.gltf")
        val renderableFuture4 = ModelRenderable.builder()
            .setSource(
                this, RenderableSource.builder().setSource(
                    this,
                    modelUri4,
                    RenderableSource.SourceType.GLTF2
                )
                    .setScale(0.06f)
                    .setRecenterMode(RenderableSource.RecenterMode.ROOT)
                    .build()
            )
            .setRegistryId("Plant4")
            .build()
        renderableFuture4.thenAccept { plantRenderable4 = it }
        renderableFuture4.exceptionally { _ ->
            Toast.makeText(this, "error loading renderablefuture ", Toast.LENGTH_LONG).show()
            null
        }

        val modelUri5 = Uri.parse("FiddleleafFigPottedPlant.gltf")
        val renderableFuture5 = ModelRenderable.builder()
            .setSource(
                this, RenderableSource.builder().setSource(
                    this,
                    modelUri5,
                    RenderableSource.SourceType.GLTF2
                )
                    .setScale(0.06f)
                    .setRecenterMode(RenderableSource.RecenterMode.ROOT)
                    .build()
            )
            .setRegistryId("Plant5")
            .build()
        renderableFuture5.thenAccept { plantRenderable5 = it }
        renderableFuture5.exceptionally { _ ->
            Toast.makeText(this, "error loading renderablefuture ", Toast.LENGTH_LONG).show()
            null
        }

        val modelUri6 = Uri.parse("minisun.gltf")
        val renderableFuture6 = ModelRenderable.builder()
            .setSource(
                this, RenderableSource.builder().setSource(
                    this,
                    modelUri6,
                    RenderableSource.SourceType.GLTF2
                )
                    .setScale(0.1f)
                    .setRecenterMode(RenderableSource.RecenterMode.ROOT)
                    .build()
            )
            .setRegistryId("vitamin1")
            .build()
        renderableFuture6.thenAccept { vitaminRenderable = it }
        renderableFuture6.exceptionally { _ ->
            Toast.makeText(this, "error loading renderablefuture ", Toast.LENGTH_LONG).show()
            null
        }

    }

    private fun setupClickListener() {
        for( i in arrayView.indices) {
            arrayView[i].setOnClickListener(this)
        }
    }

    private fun setupArray() {
        arrayView = arrayOf(plant1, plant2, plant3, plant4, plant5, vitamin)
    }
}