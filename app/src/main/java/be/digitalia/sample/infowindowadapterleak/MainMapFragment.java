package be.digitalia.sample.infowindowadapterleak;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainMapFragment extends SupportMapFragment implements OnMapReadyCallback {

	private static final LatLng POSITION = new LatLng(50.84571, 4.363557);

	private final GoogleMap.InfoWindowAdapter infoWindowAdapter = new GoogleMap.InfoWindowAdapter() {

		@Override
		public View getInfoWindow(Marker marker) {
			return null;
		}

		@Override
		public View getInfoContents(Marker marker) {
			// Return a sample view inflated using the current context
			return LayoutInflater.from(getContext()).inflate(R.layout.infowindow_contents, null, false);
		}
	};

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);

		setRetainInstance(true);
		getMapAsync(this);
	}

	@Override
	public void onMapReady(GoogleMap googleMap) {
		googleMap.setInfoWindowAdapter(infoWindowAdapter);

		googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(POSITION, 17));
		googleMap.addMarker(new MarkerOptions().position(POSITION));
	}
}
