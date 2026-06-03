package com.example.marvelapps.Message

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.marvelapps.Message.tutorial.TutorialMessageActivity
import com.example.marvelapps.R
import com.example.marvelapps.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://p16-capcut-va.ibyteimg.com/tos-alis-i-bv9jr6pwzx-us/005e0467776d499499806a64098935c1~tplv-photomode-zoom:600:600.webp"),
        MessageModel("Budi", "Sudah makan?", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_u9Z1f-X8W9L5mC_V8N3jO_C-wS9_vW09-A&s"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_x-vX_k_8K5K9H6v6N9k6K8-L6D6V6X-v6A&s"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_pX-v_k_8K5K9H6v6N9k6K8-L6D6V6X-v6A&s"),
        MessageModel("Eka", "Nice job kemarin!", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_k-vX_k_8K5K9H6v6N9k6K8-L6D6V6X-v6A&s"),
        MessageModel("Fajar", "Lagi ngapain?", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2_y-vX_k_8K5K9H6v6N9k6K8-L6D6V6X-v6A&s"),
        MessageModel("Gita", "Boleh minta tolong?", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3_z-vX_k_8K5K9H6v6N9k6K8-L6D6V6X-v6A&s"),
        MessageModel("Hana", "Lihat email ya", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4_w-vX_k_8K5K9H6v6N9k6K8-L6D6V6X-v6A&s"),
        MessageModel("Irfan", "Oke noted", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5_q-vX_k_8K5K9H6v6N9k6K8-L6D6V6X-v6A&s"),
        MessageModel("Joko", "Sampai jumpa besok", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS6_r-vX_k_8K5K9H6v6N9k6K8-L6D6V6X-v6A&s")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Message"
        }
        
        // Aktifkan Option Menu di Fragment
        setHasOptionsMenu(true)

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tutorial -> {
                val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}