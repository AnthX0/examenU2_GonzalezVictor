package mx.edu.potros.examenu2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class Regalos : AppCompatActivity() {
    var detallesAdapter: DetalleAdapter? = null
    var globosAdapter: DetalleAdapter? = null
    var peluchesAdapter: DetalleAdapter? = null
    var regalosAdapter: DetalleAdapter? = null
    var tazasAdapter: DetalleAdapter? = null

    var detalles = ArrayList<Detalles>()
    var globos = ArrayList<Detalles>()
    var peluches = ArrayList<Detalles>()
    var regalos = ArrayList<Detalles>()
    var tazas = ArrayList<Detalles>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)

        cargarDetalles()

        detallesAdapter = DetalleAdapter(this, detalles)
        globosAdapter = DetalleAdapter(this, globos)
        peluchesAdapter = DetalleAdapter(this, peluches)
        regalosAdapter = DetalleAdapter(this, regalos)
        tazasAdapter = DetalleAdapter(this, tazas)

        var gridDetalles: GridView = findViewById(R.id.regalos)

        gridDetalles.adapter = detallesAdapter
    }

    private fun cargarDetalles() {
        detalles.add(Detalles(R.drawable.cumplebotanas, "$280"))
        detalles.add(Detalles(R.drawable.cumplecheve, "$280"))
        detalles.add(Detalles(R.drawable.cumpleescolar, "$280"))
        detalles.add(Detalles(R.drawable.cumplepaletas, "$280"))
        detalles.add(Detalles(R.drawable.cumplesnack, "$280"))
        detalles.add(Detalles(R.drawable.cumplevinos, "$280"))
    }

    class DetalleAdapter: BaseAdapter {
        var detalles = ArrayList<Detalles>()
        var context: Context? = null

        constructor(
            context: Context,
            peliculas: ArrayList<Detalles>
        ) : super() {
            this.detalles = peliculas
            this.context = context
        }

        override fun getCount(): Int {
            return detalles.size
        }

        override fun getItem(pos: Int): Any {
            return detalles[pos]
        }

        override fun getItemId(pos: Int): Long {
            return pos.toLong()
        }

        override fun getView(pos: Int,
                             convertView: View?,
                             parent: ViewGroup?): View {
            var detalle = detalles[pos]
            var inflator = context!!.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.detalles, null)
            var image: ImageView = vista.findViewById(R.id.image_detalles_cell)
            var title: TextView = vista.findViewById(R.id.detalles_price_cell)

            image.setImageResource(detalle.image)
            title.setText(detalle.precio)

            image.setOnClickListener {
                val intento = Intent(context, Detalle_Regalos::class.java)
                intento.putExtra("imagen", detalle.image)
                intento.putExtra("precio", detalle.precio)
                context!!.startActivity(intento)
            }

            return vista
        }
    }
}