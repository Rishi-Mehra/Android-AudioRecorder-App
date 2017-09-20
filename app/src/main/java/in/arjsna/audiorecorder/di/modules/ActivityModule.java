package in.arjsna.audiorecorder.di.modules;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import dagger.Module;
import dagger.Provides;
import in.arjsna.audiorecorder.playlist.PlayListAdapter;
import in.arjsna.audiorecorder.audiorecording.AudioRecordMVPView;
import in.arjsna.audiorecorder.audiorecording.AudioRecordPresenter;
import in.arjsna.audiorecorder.audiorecording.AudioRecordPresenterImpl;
import in.arjsna.audiorecorder.db.RecordItemDataSource;
import in.arjsna.audiorecorder.db.RecordingItem;
import in.arjsna.audiorecorder.di.ActivityContext;
import in.arjsna.audiorecorder.di.PerActivity;
import in.arjsna.audiorecorder.playlist.PlayListMVPView;
import in.arjsna.audiorecorder.playlist.PlayListPresenter;
import in.arjsna.audiorecorder.playlist.PlayListPresenterImpl;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;

@Module
public class ActivityModule {
  private AppCompatActivity appCompatActivity;

  public ActivityModule(AppCompatActivity appCompatActivity) {
    this.appCompatActivity = appCompatActivity;
  }

  @Provides
  @ActivityContext
  @PerActivity
  AppCompatActivity provideActivityContext() {
    return appCompatActivity;
  }

  @Provides
  @PerActivity
  CompositeDisposable provideCompositeDisposable() {
    return new CompositeDisposable();
  }

  @Provides
  @PerActivity
  LinearLayoutManager provideLinearLayoutManager(@ActivityContext AppCompatActivity context) {
    return new LinearLayoutManager(context);
  }

  @Provides
  @PerActivity
  PlayListAdapter providesPlayListAdapter(@ActivityContext AppCompatActivity context) {
    return new PlayListAdapter(context, new ArrayList<>());
  }

  @Provides
  @PerActivity
  AudioRecordPresenter<AudioRecordMVPView> provideAudioRecordPresenter(
      AudioRecordPresenterImpl<AudioRecordMVPView> audioRecordPresenter) {
    return audioRecordPresenter;
  }

  @Provides
  @PerActivity
  PlayListPresenter<PlayListMVPView> providePlayListPresenter(
      PlayListPresenterImpl<PlayListMVPView> playListPresenter) {
    return playListPresenter;
  }
}
