package com.example.naterial


import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.EditText

import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.fragment_recycler.*
import kotlinx.android.synthetic.main.dialog_task.*
import kotlinx.android.synthetic.main.dialog_task.view.*


class Fragment_Recycler : Fragment(R.layout.fragment_recycler) {
    private var isNewList = false
    private lateinit var itemTouchHelper: ItemTouchHelper
    private lateinit var adapter: RecyclerAdapter


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val data = arrayListOf(
            Pair(Data(1, "что то сделять", "двоадылвоадлыо"), false)
        )

        data.add(0, Pair(Data(0, "Задачи"), false))
        adapter = RecyclerAdapter(
            object : RecyclerAdapter.OnListItemClickListener {
                override fun onItemClick() {
                    //toast(data.someText)
                    showDialogButtonClicked()
                }
            },
            data,
            object : RecyclerAdapter.OnStartDragListener {
                override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
                    itemTouchHelper.startDrag(viewHolder)
                }
            }
        )

        recyclerView.adapter = adapter
        //recyclerActivityFAB.setOnClickListener { adapter.appendItem() }
        itemTouchHelper = ItemTouchHelper(ItemTouchHelperCallback(adapter))
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }


    private fun Fragment.toast(string: String?) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).apply {
            setGravity(Gravity.BOTTOM, 0, 250)
            show()
        }
    }

    fun showDialogButtonClicked() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Задача")
        val customLayout = layoutInflater.inflate(R.layout.dialog_task, null)
        builder.setView(customLayout)
        builder.setPositiveButton(
            "OK"
        ) { dialog, which ->
            adapter.appendItem(
                customLayout.et_title.text.toString(),
                customLayout.et_decs.text.toString()
            )
        }
        builder.setNegativeButton("Отмена", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }


}