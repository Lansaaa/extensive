package com.lansa.extensive.extensions

import timber.log.Timber


fun Any?.d(tag: Any? = null, prefix: String = "") = this.debug(tag, prefix)

fun Any?.e(tag: Any? = null, prefix: String = "") = this.error(tag, prefix)

fun Any?.i(tag: Any? = null, prefix: String = "") = this.info(tag, prefix)

fun Any?.v(tag: Any? = null, prefix: String = "") = this.verbose(tag, prefix)

fun Any?.w(tag: Any? = null, prefix: String = "") = this.warn(tag, prefix)


fun Any?.debug(tag: Any? = null, prefix: String = "") {
    return Timber.tag(if (tag == null) "" else "$tag").d("$prefix\t${toString()}")
}

fun Any?.info(tag: Any? = null, prefix: String = "") {
    return Timber.tag(if (tag == null) "" else "$tag").i("$prefix\t${toString()}")
}

fun Any?.error(tag: Any? = null, prefix: String = "") {
    return Timber.tag(if (tag == null) "" else "$tag").e("$prefix\t${toString()}")
}

fun Any?.verbose(tag: Any? = null, prefix: String = "") {
    return Timber.tag(if (tag == null) "" else "$tag").v("$prefix\t${toString()}")
}

fun Any?.warn(tag: Any? = null, prefix: String = "") {
    return Timber.tag(if (tag == null) "" else "$tag").w("$prefix\t${toString()}")
}



