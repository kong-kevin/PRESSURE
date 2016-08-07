#include <jni.h>
#include <stdlib.h>
int getPressure(){

	return rand()%100+1;
}
int flag = 0;

JNIEXPORT void JNICALL Java_com_kong_pressure_MainActivity_startMoniter(
		JNIEnv *env, jobject obj){
 flag = 1;
 while(flag){
	 sleep(1);
	 jclass clazz=(*env)->FindClass(env,"com/kong/pressure/MainActivity");
	 jmethodID methodID = (*env)->GetMethodID(env,clazz,"setPressure", "(I)V");
	 (*env)->CallVoidMethod(env,obj,methodID,getPressure());
 }

}

/*
 * Class:     com_kong_pressure_MainActivity
 * Method:    stopMoniter
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_kong_pressure_MainActivity_stopMoniter(
		JNIEnv * env, jobject obj) {
	flag = 0;

}
;

