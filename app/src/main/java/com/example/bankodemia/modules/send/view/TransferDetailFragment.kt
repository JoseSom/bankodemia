package com.example.bankodemia.modules.send.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.example.bankodemia.core.util.FieldTypeEnum
import com.example.bankodemia.core.util.activateButton
import com.example.bankodemia.core.util.validateField
import com.example.bankodemia.databinding.FragmentTransferDetailBinding
import com.example.bankodemia.core.util.Fields

class TransferDetailFragment : Fragment(), Fields {
    private var _binding: FragmentTransferDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTransferDetailBinding.inflate(inflater, container, false)
        validationFields()
        return binding.root
    }

    override fun validationFields() {
        var checkTransfer: Boolean
        with(binding) {
            transferTietAmount.addTextChangedListener {
                checkTransfer = validateField(
                    fragment = this@TransferDetailFragment,
                    typeEnum = FieldTypeEnum.NUMBER,
                    transferTilAmount
                )
                activateButton(
                    fragment = this@TransferDetailFragment,
                    transferBtnMakeTransfer,
                    checkTransfer
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}