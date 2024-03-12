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
import android.widget.Button
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        var detallesButton : Button = findViewById(R.id.btnDetalles)
        var globosButton : Button = findViewById(R.id.btnGlobos)
        var peluchesButton : Button = findViewById(R.id.btnPeluches)
        var regalosButton : Button = findViewById(R.id.btnRegalos)
        var tazasButton : Button = findViewById(R.id.btnTazas)

        detallesButton.setOnClickListener {
            var intent: Intent = Intent(this,
                Regalos::class.java)
            startActivity(intent)
        }

        globosButton.setOnClickListener {
            var intent: Intent = Intent(this,
                Regalos::class.java)
            startActivity(intent)
        }

        peluchesButton.setOnClickListener {
            var intent: Intent = Intent(this,
                Regalos::class.java)
            startActivity(intent)
        }

        regalosButton.setOnClickListener {
            var intent: Intent = Intent(this,
                Regalos::class.java)
            startActivity(intent)
        }

        tazasButton.setOnClickListener {
            var intent: Intent = Intent(this,
                Regalos::class.java)
            startActivity(intent)
        }
    }
}