/*
 *
 */
#include <cstring>
#include <jni.h>
#include <cinttypes>
#include <android/log.h>
#include "lualib.h"
#include "lauxlib.h"


#define LOGI(...) \
  ((void)__android_log_print(ANDROID_LOG_INFO, "mnist::", __VA_ARGS__))

/*
 *
 */
extern "C" JNIEXPORT jstring JNICALL
Java_com_keithpinson_mnistwithtolerancemaps_MainActivity_toString(JNIEnv *env, jobject thiz) {
    LOGI("kicking off MNIST");

    return env->NewStringUTF("MNIST using torch");
}