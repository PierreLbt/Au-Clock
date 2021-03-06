package fr.pierreliaubet.au_clock;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class Questions extends AppCompatActivity {

    private Utilisateur lePigeon = new Utilisateur();
    private int cpt = 0;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);




    }

    public void clicSalope(View view){
        cpt += 1;
        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
        if (cpt == 9){
            Intent intent = getIntent();
            lePigeon = (Utilisateur) intent.getSerializableExtra("lePigeon");
            Intent home = new Intent(this, Home.class);
            home.putExtra("lePigeon", lePigeon);
            startActivity(home);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_questions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_questions, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getQuestion(getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }

        private String getQuestion(int fragment){
            String question;
            switch (fragment){
                case 1 :
                    question = "Vous endormez-vous facilement ?";
                    break;
                case 2 :
                    question = "Votre sommeil est-il réparateur ?";
                    break;
                case 3:
                    question = "Faites-vous de beaux rêves ?";
                    break;
                case 4:
                    question = "Arrivez-vous à vous réveiller naturellment sans réveil ?";
                    break;
                case 5:
                    question = "Etes-vous en pleine forme au réveil ?";
                    break;
                case 6:
                    question = "Commencez vous positivement la journée ?";
                    break;
                case 7 :
                    question = "Vos nuits sont-elles agitées ?";
                    break;
                case 8:
                    question = "Vous réveillez-vous facilement pendant la nuit ?";
                    break;
                case 9:
                    question = "Pratiquez-vous une activité physique régulière ?";
                    break;
                default:
                    question = "";
                    break;
            }
            return question;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 9;
        }
    }


}
