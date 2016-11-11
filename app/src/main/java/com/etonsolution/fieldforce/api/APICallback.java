package com.etonsolution.fieldforce.api;

/**
 * Created by Tushar on 11/11/16.
 */
public interface APICallback<T> {

	void onSuccess(T t);

	void onFailure(String errorMessage);

	void onSessionExpire();
}
