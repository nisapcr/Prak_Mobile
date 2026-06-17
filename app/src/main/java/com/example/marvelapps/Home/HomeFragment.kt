package com.example.marvelapps.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelapps.AuthActivity
import com.example.marvelapps.Data.api.PhotoApiClient
import com.example.marvelapps.Home.Pertemuan_2.SecondActivity
import com.example.marvelapps.Home.Pertemuan_3.ThirdActivity
import com.example.marvelapps.Home.Pertemuan_4.FourthActivity
import com.example.marvelapps.Home.Pertemuan_5.FifthActivity
import com.example.marvelapps.Home.pertemuan_7.SeventhActivity
import com.example.marvelapps.Home.pertemuan_9.NinthActivity
import com.example.marvelapps.Home.pertemuan_10.TenthActivity
import com.example.marvelapps.Home.pertemuan_13.ThirteenthActivity
import com.example.marvelapps.Home.photo.PhotoAdapter
import com.example.marvelapps.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }

        // 🔵 LOAD PHOTO DARI API
        loadPhoto()

        // 🔵 KE PERTEMUAN 2
        binding.btnToSecond.setOnClickListener {
            val intent = Intent(requireContext(), SecondActivity::class.java)
            startActivity(intent)
        }

        // 🔵 KE PERTEMUAN 3
        binding.btnToThird.setOnClickListener {
            val intent = Intent(requireContext(), ThirdActivity::class.java)
            startActivity(intent)
        }

        // 🔵 KE PERTEMUAN 4
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java)
            intent.putExtra("nama", "Politeknik Caltex Riau")
            intent.putExtra("asal", "Rumbai")
            intent.putExtra("usia", 25)
            startActivity(intent)
        }

        // 🔵 KE PERTEMUAN 5
        binding.btnToFifth.setOnClickListener {
            val intent = Intent(requireContext(), FifthActivity::class.java)
            startActivity(intent)
        }

        // 🔵 KE PERTEMUAN 7
        binding.btnToSeventh.setOnClickListener {
            val intent = Intent(requireContext(), SeventhActivity::class.java)
            startActivity(intent)
        }

        // 🔵 KE PERTEMUAN 9
        binding.btnToNinth.setOnClickListener {
            val intent = Intent(requireContext(), NinthActivity::class.java)
            startActivity(intent)
        }

        // 🔵 KE PERTEMUAN 10
        binding.btnToTenth.setOnClickListener {
            val intent = Intent(requireContext(), TenthActivity::class.java)
            startActivity(intent)
        }

        // 🔵 KE PERTEMUAN 13
        binding.btnToThirteenth.setOnClickListener {
            val intent = Intent(requireContext(), ThirteenthActivity::class.java)
            startActivity(intent)
        }

        // 🔴 LOGOUT
        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    
                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                    Log.e("Logout", "User logout from fragment")
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    private fun loadPhoto() {
        lifecycleScope.launch {
            try {
                // Memanggil API melalui Retrofit
                val photos = PhotoApiClient.apiService.getPhotos()
                
                // Menyiapkan Adapter
                val adapter = PhotoAdapter(photos)
                binding.rvGallery.adapter = adapter
                
                // Menentukan LayoutManager (Vertical)
                binding.rvGallery.layoutManager = LinearLayoutManager(requireContext())
                
                // Menonaktifkan nested scrolling pada RecyclerView agar scroll ditangani oleh NestedScrollView
                binding.rvGallery.isNestedScrollingEnabled = false
                
            } catch (e: Exception) {
                Log.e("API_ERROR", "Gagal memuat gambar: ${e.message}")
                Toast.makeText(requireContext(), "Gagal memuat gambar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}