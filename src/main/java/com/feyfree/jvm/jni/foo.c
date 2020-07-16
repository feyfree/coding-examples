// foo.c
#include <stdio.h>
#include "me_zhongmingmao_advanced_jni_Foo.h"

JNIEXPORT void JNICALL Java_com_feyfree_jvm_jni_Foo_bar__Ljava_lang_String_2Ljava_lang_Object_2
  (JNIEnv *env, jobject thisObject, jstring str, jobject obj) {
    printf("Hello, World\n");
    return;
}