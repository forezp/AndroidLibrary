package mydemo.forezp.com.mydemo.libraryTest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mydemo.forezp.com.mydemo.R;

public class MenuRightFragment extends Fragment
{
	private View mView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		if(mView == null)
		{
			mView = inflater.inflate(R.layout.right_menu, container, false);
		}
		return mView ;
	}
}
