package com.example.bankodemia.modules.contacts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.example.bankodemia.core.util.FieldTypeEnum
import com.example.bankodemia.core.util.activateButton
import com.example.bankodemia.core.util.validateField
import com.example.bankodemia.databinding.FragmentAddContactBinding
import com.example.bankodemia.core.util.Fields

class AddContactFragment : Fragment(), Fields {
    private var _binding: FragmentAddContactBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddContactBinding.inflate(inflater, container, false)
        validationFields()
        return binding.root
    }

    override fun validationFields() {
        var checkNumber = false
        var checkInstitution= false
        var checkFullName = false
        var checkMail = false

        with(binding) {
            addContactTietCardNumber.addTextChangedListener {
                checkNumber = validateField(
                    fragment = this@AddContactFragment,
                    typeEnum = FieldTypeEnum.NUMBER,
                    addContactTilCardNumber
                )
                activateButton(
                    fragment = this@AddContactFragment,
                    addContactBtnAddContact,
                    checkNumber, checkInstitution, checkFullName, checkMail
                )
            }

            addContactTietInstitution.addTextChangedListener {
                checkInstitution = validateField(
                    fragment = this@AddContactFragment,
                    typeEnum = FieldTypeEnum.TEXT,
                    addContactTilInstitution
                )
                activateButton(
                    fragment = this@AddContactFragment,
                    addContactBtnAddContact,
                    checkNumber, checkInstitution, checkFullName, checkMail
                )
            }

            addContactTietName.addTextChangedListener {
                checkFullName = validateField(
                    fragment = this@AddContactFragment,
                    typeEnum = FieldTypeEnum.TEXT,
                    addContactTilName
                )
                activateButton(
                    fragment = this@AddContactFragment,
                    addContactBtnAddContact,
                    checkNumber, checkInstitution, checkFullName, checkMail
                )
            }

            addContactTietEmail.addTextChangedListener {
                checkMail = validateField(
                    fragment = this@AddContactFragment,
                    typeEnum = FieldTypeEnum.EMAIL,
                    addContactTilEmail
                )
                activateButton(
                    fragment = this@AddContactFragment,
                    addContactBtnAddContact,
                    checkNumber, checkInstitution, checkFullName, checkMail
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}