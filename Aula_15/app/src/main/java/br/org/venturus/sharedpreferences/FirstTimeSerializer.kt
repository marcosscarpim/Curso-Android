/**
 * Copyright @marcosscarpim.
 */

package br.org.venturus.sharedpreferences

import androidx.datastore.core.Serializer
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.InputStream
import java.io.OutputStream

object FirstTimeSerializer: Serializer<FirstTimePreferences> {
    override val defaultValue: FirstTimePreferences
        get() = FirstTimePreferences(true, 0)

    override suspend fun readFrom(input: InputStream): FirstTimePreferences {
        return try {
            val dis = DataInputStream(input)
            FirstTimePreferences(
                dis.readBoolean(),
                dis.readLong()
            )
        } catch (exception: InvalidProtocolBufferException) {
            FirstTimePreferences(true, 0)
        }
    }

    override suspend fun writeTo(t: FirstTimePreferences, output: OutputStream) {
        val dos = DataOutputStream(output)
        dos.writeBoolean(t.isFirstTime)
        dos.writeLong(t.time)
    }
}