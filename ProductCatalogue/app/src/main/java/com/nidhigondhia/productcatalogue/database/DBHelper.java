package com.nidhigondhia.productcatalogue.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.nidhigondhia.productcatalogue.model.Product;
import java.util.ArrayList;

/**
 * Created by NIDHI on 3/12/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_PATH = "/data/data/com.nidhigondhia.productcatalogue/databases/";
    public static final String DATABASE_NAME = "product_catalogue.db";
    public static final String TABLE_APP_PRODUCT = "app_product";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_IS_FEATURE = "is_feature";
    public static final String COLUMN_IMAGE_URL = "image_url";
    public static final String COLUMN_FEATURED_IMAGE_URL = "featured_image_url";
    public static final String COLUMN_NAME_EN = "name_en_IN";
    public static final String COLUMN_NAME_HI = "name_hi_IN";

    private static final String TAG = "TAG";
    private final Context myContext;

    private static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query;
        query = "create table app_product(\n" +
                "_id integer primary key autoincrement,\n" +
                "price text,\n" +
                "is_feature integer,\n" +
                "image_url text,\n" +
                "featured_image_url text,\n" +
                "name_en_IN text,\n" +
                "name_hi_IN text \n" +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_APP_PRODUCT);
        onCreate(db);
    }
    public void insertFirstTime(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO " + TABLE_APP_PRODUCT + "  VALUES (" +
                "1," +
                "\"9,199\"," +
                "1," +
                "\"http://img5a.flixcart.com/image/mobile/z/2/j/lenovo-k3-note-na-400x400-imae8hstkr6sbtgt.jpeg\"," +
                "\"http://img6a.flixcart.com/www/promos/new/20150625-122707-banner1-reg.jpg\"," +
                "\"Lenovo K3 Note (White, 16 GB)\"," +
                "\"लेनोवो K3 नोट ( सफेद, 16 जीबी)\"" +
                ")");

         db.execSQL("INSERT INTO " + TABLE_APP_PRODUCT + "  VALUES (" +
                "2," +
                "\"9,999\"," +
                "0," +
                "\"http://img5a.flixcart.com/image/mobile/d/x/y/gionee-elife-s5-5-400x400-imadw7bvqdvgnzmh.jpeg\"," +
                "\"http://img5a.flixcart.com/image/mobile/d/x/y/gionee-elife-s5-5-400x400-imadw7bvqdvgnzmh.jpeg\"," +
                "\"Gionee Elife S5.5(White, 16 GB)\"," +
                "\"जियोनी Elife S5.5 ( सफेद, 16 जीबी)\"" +
                ")");

        db.execSQL("INSERT INTO " + TABLE_APP_PRODUCT + "  VALUES (" +
                "3," +
                "\"10,000\"," +
                "0," +
                "\"http://img5a.flixcart.com/image/mobile/h/5/d/xolo-q1000s-plus-400x400-imae2dhzgkpxcsmp.jpeg\"," +
                "\"http://img5a.flixcart.com/image/mobile/h/5/d/xolo-q1000s-plus-400x400-imae2dhzgkpxcsmp.jpeg\"," +
                "\"XOLO Q1000s Plus(White, 32 GB)\"," +
                "\"XOLO Q1000s प्लस ( सफेद, 32 जीबी)\"" +
                ")");

        db.execSQL("INSERT INTO " + TABLE_APP_PRODUCT + "  VALUES (" +
                "4," +
                "\"7,499\"," +
                "0," +
                "\"http://img5a.flixcart.com/image/mobile/r/z/z/lenovo-a6000-plus-a6000-plus-400x400-imae6fyhhrwnaywc.jpeg\"," +
                "\"http://img5a.flixcart.com/image/mobile/r/z/z/lenovo-a6000-plus-p0sb004bin-p0sb004ein-p0sb0010in-400x400-imaeg888mgaqtmvq.jpeg\"," +
                "\"Lenovo A6000 Plus(Black, 16 GB)\"," +
                "\"लेनोवो A6000 प्लस ( काले, 16 जीबी)\"" +
                ")");

        db.execSQL("INSERT INTO " + TABLE_APP_PRODUCT + "  VALUES (" +
                "5," +
                "\"6,999\"," +
                "0," +
                "\"http://img5a.flixcart.com/image/mobile/d/a/c/mi-redmi-2-enhanced-mzb4397in-400x400-imae9t7zznk4yhrs.jpeg\"," +
                "\"http://img5a.flixcart.com/image/mobile/d/a/c/mi-redmi-2-enhanced-mzb4397in-400x400-imae9t7zznk4yhrs.jpeg\"," +
                "\"Redmi 2 Prime(Grey, 16 GB)\"," +
                "\"Redmi 2 प्रधान (ग्रे , 16 जीबी)\"" +
                ")");

        db.execSQL("INSERT INTO " + TABLE_APP_PRODUCT + "  VALUES (" +
                "6," +
                "\"10,999\"," +
                "0," +
                "\"http://img5a.flixcart.com/image/mobile/g/u/c/motorola-moto-g-3rd-generation-ap3522ad1k8-400x400-imae9h4kydnyervx.jpeg\"," +
                "\"http://img5a.flixcart.com/image/mobile/g/u/c/motorola-moto-g-3rd-generation-xt-1550-400x400-imaefthsuepx4suc.jpeg\"," +
                "\"Moto G (3rd Generation)(White, 16 GB)\"," +
                "\"मोटो जी (3 जनरेशन ) ( सफेद, 16 जीबी)\"" +
                ")");

        db.execSQL("INSERT INTO " + TABLE_APP_PRODUCT + "  VALUES (" +
                "7," +
                "\"39,999\"," +
                "0," +
                "\"http://img6a.flixcart.com/image/mobile/9/w/f/huawei-nexus-6p-nin-a2-400x400-imaebyyyhxgugwna.jpeg\"," +
                "\"http://img6a.flixcart.com/image/mobile/k/x/t/huawei-nexus-6p-h1512-400x400-imaefthshafg4nsh.jpeg\"," +
                "\"Nexus 6P(Silver, 32 GB)\"," +
                "\"नेक्सस 6P (रजत, 32 जीबी)\"" +
                ")");

        db.execSQL("INSERT INTO " + TABLE_APP_PRODUCT + "  VALUES (" +
                "8," +
                "\"35,490\"," +
                "1," +
                "\"http://img5a.flixcart.com/image/mobile/4/s/r/lg-nexus-5x-lgh791-400x400-imaecgqkgxrys3fg.jpeg\"," +
                "\"http://www.pocketables.com/images/2013/11/Nexus-5-Google-Play-Banner-608x176.png\"," +
                "\"Nexus 5X(Ice, 16 GB)\"," +
                "\"नेक्सस 5X (आइस , 16 जीबी)\"" +
                ")");

        db.execSQL("INSERT INTO " + TABLE_APP_PRODUCT + "  VALUES (" +
                "9," +
                "\"28,999\"," +
                "0," +
                "\"http://img5a.flixcart.com/image/mobile/k/p/p/motorola-moto-x-style-xt1572-400x400-imaebugedxgxfr6g.jpeg\"," +
                "\"http://www.pocketables.com/images/2013/11/Nexus-5-Google-Play-Banner-608x176.png\"," +
                "\"Moto X Style(Black, 32 GB)\"," +
                "\"मोटो एक्स शैली ( काले, 32 जीबी)\"" +
                ")");
        db.close();
    }

    /**
     * get all products list
     * @param current_language languagle locale to get products
     * @return product list
     */
    public ArrayList<Product> getProductsLanguageWise(String current_language) {
        ArrayList<Product> arrProducts = new ArrayList<Product>();
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT " +
                "name_" + current_language + " as `name`, " +
                COLUMN_PRICE + "," +
                COLUMN_IMAGE_URL + "," +
                COLUMN_FEATURED_IMAGE_URL + "," +
                COLUMN_IS_FEATURE + " FROM " + TABLE_APP_PRODUCT;

        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.setName(cursor.getString(cursor.getColumnIndex("name")));
                product.setPrice(cursor.getString(cursor.getColumnIndex(COLUMN_PRICE)));
                product.setImage_url(cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE_URL)));
                product.setFeature_image_url(cursor.getString(cursor.getColumnIndex(COLUMN_FEATURED_IMAGE_URL)));
                product.setIs_feature(cursor.getInt(cursor.getColumnIndex(COLUMN_IS_FEATURE)));

                arrProducts.add(product);
            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return arrProducts;
    }

    /**
     * search product
     * @param current_language current lang
     * @param search search string
     * @return
     */
    public ArrayList<Product> searchProduct(String current_language,String search) {

        String searchWildCard = "%" + search + "%";
        ArrayList<Product> arrProducts = new ArrayList<Product>();
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT " +
                "name_" + current_language + " as `name`, " +
                COLUMN_PRICE + "," +
                COLUMN_IMAGE_URL + "," +
                COLUMN_FEATURED_IMAGE_URL + "," +
                COLUMN_IS_FEATURE + " FROM " + TABLE_APP_PRODUCT +
                " where name_"+ current_language + " LIKE ?" ;

        Cursor cursor = database.rawQuery(query,new String[]{searchWildCard});


        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.setName(cursor.getString(cursor.getColumnIndex("name")));
                product.setPrice(cursor.getString(cursor.getColumnIndex(COLUMN_PRICE)));
                product.setImage_url(cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE_URL)));
                product.setFeature_image_url(cursor.getString(cursor.getColumnIndex(COLUMN_FEATURED_IMAGE_URL)));
                product.setIs_feature(cursor.getInt(cursor.getColumnIndex(COLUMN_IS_FEATURE)));

                arrProducts.add(product);
            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return arrProducts;
    }

    /**
     * get all featured image
     * @return product list of feature images
     */
    public ArrayList<Product> getFeaturedImages() {
        ArrayList<Product> arrProducts = new ArrayList<Product>();
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT " +
                COLUMN_FEATURED_IMAGE_URL + " FROM " + TABLE_APP_PRODUCT +
                " where "+ COLUMN_IS_FEATURE  + "=1" ;

        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.setFeature_image_url(cursor.getString(cursor.getColumnIndex(COLUMN_FEATURED_IMAGE_URL)));
                arrProducts.add(product);
            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return arrProducts;
    }

    /**
     * check if table is empty
     * @return true if it is else false
     */
    public boolean isEmpty(){
        boolean empty = false;
        String Query = "SELECT count(*) FROM " + TABLE_APP_PRODUCT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(Query,null);
        cursor.moveToFirst();
        if(cursor.getInt(0) > 0)
            empty = false;
        else
            empty = true;
        return  empty;
    }
}