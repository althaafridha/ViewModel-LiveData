package com.salim.android.viewmodel_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.salim.android.viewmodel_livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

//	private var scoreA = 0
//	private var scoreB = 0

	private lateinit var binding: ActivityMainBinding

	private lateinit var getScoreViewModel: GetScoreViewModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		getScoreViewModel = ViewModelProvider(this).get(GetScoreViewModel::class.java)

		initView()

		binding.btnPlusScoreTeamA.setOnClickListener(this)
		binding.btnMinusScoreTeamA.setOnClickListener(this)
		binding.btnPlusScoreTeamB.setOnClickListener(this)
		binding.btnMinusScoreTeamB.setOnClickListener(this)
		binding.btnReset.setOnClickListener(this)

	}

	private fun initView() {
//		mendapatkan data score menggunakan LiveData
//		agar data yang sudah diubah masuh bisa di observe oleh UI nya
		getScoreViewModel.getScoreA()?.observe(this, Observer {
//			menampilkan LiveData agar setiap perubahan yang ada diluar LiveData bisa ditampilkan
			if (it != null){
				binding.tvScoreTeamA.text = it.toString()
			}
		})
		getScoreViewModel.getScoreB()?.observe(this, Observer {
			if (it != null){
				binding.tvScoreTeamB.text = it.toString()
			}
		})
	}

	override fun onClick(view: View?) {
		when (view?.id) {
			R.id.btnPlusScoreTeamA -> {
				getScoreViewModel.addScoreA()
			}
			R.id.btnMinusScoreTeamA -> {
				getScoreViewModel.minScoreA()
			}
			R.id.btnPlusScoreTeamB -> {
				getScoreViewModel.addScoreB()
			}
			R.id.btnMinusScoreTeamB -> {
				getScoreViewModel.minScoreB()
			}
			R.id.btnReset -> {
				getScoreViewModel.resetScore()
			}
		}
	}

//	// plus score
//	private fun addScoreA() {
//		scoreA += 1
//		binding.tvScoreTeamA.text = scoreA.toString()
//	}
//
//	private fun addScoreB() {
//		scoreB += 1
//		binding.tvScoreTeamB.text = scoreB.toString()
//	}
//
//	//	minus score
//	private fun minScoreA() {
//		scoreA -= 1
//		binding.tvScoreTeamA.text = scoreA.toString()
//	}
//	private fun minScoreB() {
//		scoreB -= 1
//		binding.tvScoreTeamB.text = scoreB.toString()
//	}
//
//	private fun resetScore(){
//		scoreA = 0
//		binding.tvScoreTeamA.text = scoreA.toString()
//		scoreB = 0
//		binding.tvScoreTeamB.text = scoreB.toString()
//	}
}