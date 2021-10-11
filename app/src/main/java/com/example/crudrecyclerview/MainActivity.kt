package com.example.crudrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var inputNIS : EditText
    private lateinit var inputNama : EditText
    private lateinit var jkLakiLaki : RadioButton
    private lateinit var jkPerempuan : RadioButton
    private lateinit var btnTambah : Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputNIS = findViewById(R.id.txtinputNIS)
        inputNama= findViewById(R.id.txtNamaLengkap)
        jkLakiLaki= findViewById(R.id.rbLakiLaki)
        jkPerempuan= findViewById(R.id.rbPerempuan)
        btnTambah= findViewById(R.id.btnTambah)
        recyclerView= findViewById(R.id.listData)
        //membuat variabel kosong tipe array Mutablelist untuk simpan data array
        //data array disimpan di data class Siswa data
        val data = mutableListOf<SiswaData>()
        viewManager= LinearLayoutManager(this)
        recyclerAdapter= SiswaAdapter(data)
        recyclerView.adapter= recyclerAdapter
        recyclerView.layoutManager=viewManager
        //setOnclickListener untuk tombol tambah data
        btnTambah.setOnClickListener{
            val nis = inputNIS.text.toString()
            val nama = inputNama.text.toString()
            var jk = ""
            if(jkLakiLaki.isChecked){
                jk="Laki-Laki"
            } else {jkPerempuan
            }
                // simpan data ke array mutable list
            val dataSiswa = SiswaData(nis,nama, jk)
            data.add(dataSiswa)
            recyclerAdapter.notifyDataSetChanged()
        }

    }


}