/*
 * This source is part of the
 *      _____  ___   ____
 *  __ / / _ \/ _ | / __/___  _______ _
 * / // / , _/ __ |/ _/_/ _ \/ __/ _ `/
 * \___/_/|_/_/ |_/_/ (_)___/_/  \_, /
 *                              /___/
 * repository.
 *
 * Copyright (C) 2019-present Benoit 'BoD' Lubek (BoD@JRAF.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jraf.ktorhttpclientsample.sample

import kotlinx.coroutines.runBlocking
import org.jraf.ktorhttpclientsample.client.Authentication
import org.jraf.ktorhttpclientsample.client.ClientConfiguration
import org.jraf.ktorhttpclientsample.client.HttpConfiguration
import org.jraf.ktorhttpclientsample.client.HttpLoggingLevel
import org.jraf.ktorhttpclientsample.client.HttpProxy
import org.jraf.ktorhttpclientsample.client.SampleClient
import kotlin.system.exitProcess

private const val LOGIN = "xxx"
private const val SECRET_KEY = "yyy"

class Sample {
    private val client: SampleClient by lazy {
        // Create the client
        SampleClient.newInstance(
            ClientConfiguration(
                Authentication(
                    LOGIN,
                    SECRET_KEY
                ),
                HttpConfiguration(
                    // Uncomment to see more logs
                    // loggingLevel = HttpLoggingLevel.BODY,
                    loggingLevel = HttpLoggingLevel.INFO,
                    // This is only needed to debug with, e.g., Charles Proxy
//                    httpProxy = HttpProxy("localhost", 8888)
                )
            )
        )
    }

    fun main() {
        runBlocking {
            // Get organization
            println("Todo:")
            val todo = client.getTodo()
            println(todo)
        }

        // Close
        client.close()

        // Exit process
        exitProcess(0)
    }
}

fun main() = Sample().main()
