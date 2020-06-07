package com.mattar.whocovid19.kodein

import androidx.fragment.app.Fragment
import org.kodein.di.Kodein
import org.kodein.di.bindings.BindingKodein
import org.kodein.di.bindings.ExternalSource
import org.kodein.di.fullErasedName
import org.kodein.di.jvmType

class FragmentArgsExternalSource : ExternalSource {
    override fun getFactory(kodein: BindingKodein<*>, key: Kodein.Key<*, *, *>): ((Any?) -> Any)? {
        val fragment = kodein.context as? Fragment

        if (fragment != null) {
            val deductedArgsClassName = fragment.javaClass.canonicalName + "Args"

            if (deductedArgsClassName == key.type.jvmType.fullErasedName()) {


            }
        }

        return null
    }
}
