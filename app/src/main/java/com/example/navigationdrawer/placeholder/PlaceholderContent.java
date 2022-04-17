package com.example.navigationdrawer.placeholder;

import android.util.Log;

import com.example.navigationdrawer.MainActivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    public static List<PlaceholderContent.Machine> ITEMS = new ArrayList<>();

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<Integer, PlaceholderContent.Machine> ITEM_MAP = new HashMap<>();

//    private static final int COUNT = 25;

    static {

    }
    public static void fill(List<PlaceholderContent.Machine> machines){

        Log.d("a3",machines+"");
        for (Machine item: machines) {
            addItem(createMachine(item));
        }
        Log.d("ahmama", ITEMS+"");
    }
    private static void addItem(Machine item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Machine createMachine(Machine position) {
        return new Machine(position.id, position.reference, position.dateAchat, position.prix, position.marque);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();

    }

    /**
     * A placeholder item representing a piece of content.
     */
    public static class Machine {
        private int id;
        private String reference;
        private Date dateAchat;
        private double prix;
        private Marque marque;

        public Machine(int id, String reference, Date dateAchat, double prix, Marque marque) {
            this.id = id;
            this.reference = reference;
            this.dateAchat = dateAchat;
            this.prix = prix;
            this.marque = marque;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public Date getDateAchat() {
            return dateAchat;
        }

        public void setDateAchat(Date dateAchat) {
            this.dateAchat = dateAchat;
        }

        public double getPrix() {
            return prix;
        }

        public void setPrix(double prix) {
            this.prix = prix;
        }

        public Marque getMarque() {
            return marque;
        }

        public void setMarque(Marque marque) {
            this.marque = marque;
        }

        @Override
        public String toString() {
            return "Machine{" +
                    "id=" + id +
                    ", reference='" + reference + '\'' +
                    ", dateAchat=" + dateAchat +
                    ", prix=" + prix +
                    ", marque=" + marque +
                    '}';
        }
    }

}