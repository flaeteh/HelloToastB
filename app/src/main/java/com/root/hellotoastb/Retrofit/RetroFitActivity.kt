@file:Suppress("DEPRECATION")
package com.root.hellotoastb.Retrofit
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.root.hellotoastb.R
import com.root.hellotoastb.adapters.EmployeesAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_retro_fit.*

class RetroFitActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var eAdapter: EmployeesAdapter? = null

    val emp by lazy {
        EmployeeInterface.create()
    }

    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retro_fit)

        showEmployees()
    }

    fun Recycler(employeesList: List<Employee>) {
        RecyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        RecyclerView.layoutManager = layoutManager
        RecyclerView.adapter = EmployeesAdapter(employeesList){
            Log.v("", it.employeeId.toString())
        }

        /*employeeList = response.body()!!.employee
        recyclerView = findViewById(R.id.RecyclerView)
        eAdapter = EmployeesAdapter(employeesList)
        val eLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView?.layoutManager = eLayoutManager
        recyclerView?.itemAnimator = DefaultItemAnimator()
        recyclerView?.adapter = eAdapter
        eAdapter!!.notifyDataSetChanged()*/
    }

    //get list of employees
    private fun showEmployees() {
        disposable = emp.getEmployees()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            result -> Recycler(result.employee as ArrayList)
                        },
                        {
                            error -> Log.e("ERROR", error.message)
                        }
                )

    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

    companion object {
        private val TAG = RetroFitActivity::class.java.simpleName
    }

}