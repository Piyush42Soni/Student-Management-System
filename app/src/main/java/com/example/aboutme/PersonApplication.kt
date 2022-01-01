package com.example.aboutme

import android.app.Application
import com.example.aboutme.Main_Activities.MainViewModelFactory
import com.example.aboutme.data.Person_Database
import com.example.aboutme.data.repositories.Person_Repo
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class PersonApplication: Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@PersonApplication))
        bind() from singleton { Person_Database(instance()) }
        bind() from singleton { Person_Repo(instance()) }
        bind() from provider { MainViewModelFactory(instance()) }
    }
}