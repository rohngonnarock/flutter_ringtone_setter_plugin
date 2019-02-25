package com.rohngonnarock.ringtonesetter;

import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** RingtoneSetterPlugin */
public class RingtoneSetterPlugin implements MethodCallHandler {
  private RingtoneSetterPlugin(Registrar registrar){
    this.ringtone = RingtoneManager.getRingtone(registrar.context().getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
    this.ringtone.setStreamType(AudioManager.STREAM_ALARM);
  }

  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "ringtone_setter");
    channel.setMethodCallHandler(new RingtoneSetterPlugin(registrar));
  }

  @Override
	public void onMethodCall(MethodCall call, Result result) {
		System.out.println("printing");
		System.out.println(call.argument("name"));
		switch (call.method) {
			case "play":
			{
				ringtone.play();
				result.success(null);
			}
			break;

			case "stop":
			{
				ringtone.stop();
				result.success(null);
			}
			break;

			default:
			{
				result.notImplemented();
			}
		}
  }
  
  private final Ringtone ringtone;

	// private boolean echo(final String file, final String title, final String artist, final String tipo, final CallbackContext callbackContext) {
	// 	if (!Settings.System.canWrite(cordova.getActivity().getApplicationContext())) {
	// 		Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
	// 		intent.setData(Uri.parse("package:io.ionic.starter"));
	// 		cordova.getActivity().startActivity(intent);
	// 	}

	// 	if (tipo.equals("alarm") || tipo.equals("notification") || tipo.equals("ringtone")) {
	// 		setAssets(tipo, file, title, artist, callbackContext);
	// 	} else {
	// 		callbackContext.error("tipo " + tipo + "not valid");
	// 	}
	// }

	// private void setAssets(String type, String file, String title, String artist, CallbackContext callbackContext) {
	// 	File soundFile = new File(file.replaceAll("file:", ""));
	// 	setRingtone(type, soundFile, callbackContext, title, artist);
	// }

	// private void setRingtone(String type, File newSoundFile, CallbackContext callbackContext, String title, String artist) {
	// 	if (artist.equals("")) {
	// 		artist = cordova.getActivity().getPackageManager().getApplicationLabel(
	// 				cordova.getActivity().getApplicationInfo()).toString();
	// 	}
	// 	ContentValues values = new ContentValues();
	// 	values.put(MediaStore.MediaColumns.DATA, newSoundFile.getAbsolutePath());
	// 	values.put(MediaStore.MediaColumns.TITLE, title.replaceAll("[^\\\\dA-Za-z0-9_]", ""));
	// 	String filenameArray[] = newSoundFile.getName().split("\\.");
	// 	values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/" + filenameArray[filenameArray.length - 1]);
	// 	values.put(MediaStore.MediaColumns.SIZE, newSoundFile.length());
	// 	values.put(MediaStore.Audio.Media.ARTIST, artist.replaceAll("[^\\\\dA-Za-z0-9_]", ""));
	// 	values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
	// 	values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
	// 	values.put(MediaStore.Audio.Media.IS_ALARM, true);
	// 	values.put(MediaStore.Audio.Media.IS_MUSIC, false);

	// 	Uri uri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
	// 	cordova.getActivity().getContentResolver().delete(uri, MediaStore.MediaColumns.DATA + "=\"" + newSoundFile.getAbsolutePath() + "\"", null);
	// 	Uri newUri = cordova.getActivity().getContentResolver().insert(uri, values);
	// 	try {
	// 		if (type.equals("alarm")) {
	// 			RingtoneManager.setActualDefaultRingtoneUri(
	// 					cordova.getActivity(), RingtoneManager.TYPE_ALARM, newUri);
	// 			callbackContext.success("success setting " + newSoundFile.getAbsolutePath() + " as " + type);
	// 		} else if (type.equals("notification")) {
	// 			RingtoneManager.setActualDefaultRingtoneUri(
	// 					cordova.getActivity(), RingtoneManager.TYPE_NOTIFICATION, newUri);
	// 			callbackContext.success("success setting " + newSoundFile.getAbsolutePath() + " as " + type);
	// 		} else if (type.equals("ringtone")) {
	// 			RingtoneManager.setActualDefaultRingtoneUri(
	// 					cordova.getActivity(), RingtoneManager.TYPE_RINGTONE, newUri);
	// 			callbackContext.success("success setting " + newSoundFile.getAbsolutePath() + " as " + type);
	// 		} else {
	// 			callbackContext.error("tipo " + type + "not valid");
	// 		}
	// 	} catch(Throwable t) {
	// 		Log.d("tag", "catch exception");
	// 		callbackContext.error("Error setting as " + type + t.getMessage() + ". Destino: " + newSoundFile.getPath());
	// 	}
	// }
}
