package hyunji.realmtestproject;

import android.os.Bundle;
import android.widget.TextView;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;


public class MainActivity extends RxAppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.text1)
    TextView simpleTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        /** TEST 01
        Observable<String> simpleObservable =
                Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {

                        subscriber.onNext("Hello test RxAndroid");
                        subscriber.onCompleted();
                    }
                }).compose(this.<String>bindToLifecycle());
        simpleObservable.subscribe(new Subscriber<String>() {
            @Override
            public void onNext(String s) {

                ((TextView) findViewById(R.id.text1)).setText(s);
                Log.d(TAG,"jelly onNext");
            }
            @Override
            public void onCompleted() {
                Log.d(TAG,"jelly onComleted");
            }

            @Override
            public void onError(Throwable e) {

            }

        });**/

        /** TEST 02
        Observable
                .just("Hello RxAndroid!!")
                .compose(this.<String>bindToLifecycle())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        ((TextView) findViewById(R.id.text1)).setText(s);
                    }
                });
         **/

        /**
         * RetroRamda
         * **/
        Observable
                .just("Hello RxAndroid!!")
                .compose(bindToLifecycle())
                .subscribe(s->{
                    simpleTextview.setText(s);
                });
    }



}
