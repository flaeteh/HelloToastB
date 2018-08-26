package com.root.hellotoastb.adapters
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.root.hellotoastb.R
import com.root.hellotoastb.Retrofit.Employee
import kotlinx.android.synthetic.main.retro_fit_list.view.*

class EmployeesAdapter(
        private val employeesList: List<Employee>,
        private val listener: (Employee) -> Int) : RecyclerView.Adapter<EmployeesAdapter.ViewHolder>() {

    override fun getItemCount() = employeesList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(employee: Employee) = with(itemView) {
            employeeName.text = employee.name
            job.text = employee.job
            email.text = employee.email
            salary.text = employee.salary
            birthday.text = employee.birthday
            contact.text = employee.contact
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.retro_fit_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(employeesList[position])

}