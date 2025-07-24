package com.rixar.common.products;

public enum StoreKeepingUnit {


    UNIT("Units", "Unit", "Units", "1. Units"),
    PIECE("Piece", "Piece", "Pieces", "1. Units"),
    SETS("Sets", "Set", "sets", "1. Units"),
    PAIRS("Pairs", "Pair", "pairs", "1. Units"),
    DOZENS("Dozens", "Dozen", "dozens", "1. Units"),

    BOXES("Boxes", "Box", "boxes", "2. Packaging"),
    BAGS("Bags", "Bag", "bags", "2. Packaging"),
    PACKETS("Packets", "Packet", "packets", "2. Packaging"),
    CARTONS("Cartons", "Carton", "cartons", "2. Packaging"),
    CASES("Cases", "Case", "cases", "2. Packaging"),
    BOTTLES("Bottles", "Bottle", "bottles", "2. Packaging"),
    ROLLS("Rolls", "Roll", "rolls", "2. Packaging"),
    SHEETS("Sheets", "Sheet", "sheets", "2. Packaging"),
    BARRELS("Barrels", "Barrel", "barrels", "2. Packaging"),
    DRUMS("Drums", "Drum", "drums", "2. Packaging"),
    BUNDLES("Bundles", "Bundle", "bundles", "2. Packaging"),
    BUNCHES("Bunches", "Bunch", "bunches", "2. Packaging"),

    GRAMS("Grams", "gm", "gm", "3. Weight"),
    KILOGRAMS("Kilograms", "Kg", "Kg", "3. Weight"),
    TONS("Tons", "Ton", "Tons", "3. Weight"),

    SQUARE_INCH("Square Inches", "Square Inch", "Square Inch", "4. Area"),
    SQUARE_FEET("Square Feet", "Square Foot", "Square Feet", "4. Area"),
    SQUARE_METER("Square Meters", "Square Meter", "sqm", "4. Area"),
    SQUARE_KILOMETER("Square Kilometers", "Square Kilometer", "skm", "4. Area"),

    LITERS("Liters", "Liter", "Lt", "5. Volume"),
    CUBIC_CENTIMETERS("Cubic Centimeters", "Cubic Centimeter", "cc", "5. Volume"),
    CUBIC_METERS("Cubic Meters", "Cubic Meter", "cm3", "5. Volume"),
    GALLONS("Gallons", "Gallon", "gl", "5. Volume"),
    BUCKETS("Buckets", "Bucket", "buckets", "5. Volume"),

    MILLIMETER("Millimeters", "Millimeter", "mm", "6. Length"),
    CENTIMETERS("Centimeters", "Centimeter", "cm", "6. Length"),
    INCHES("Inches", "Inch", "inches", "6. Length"),
    FEET("Feet", "Foot", "ft", "6. Length"),
    METERS("Meters", "Meter", "m", "6. Length"),
    KILOMETERS("Kilometers", "Kilometer", "Km", "6. Length");



    public final String label;
    public final String labelSingular;
    public final String symbol;
    public final String category;

    StoreKeepingUnit(String label, String labelSingular, String symbol, String category) {
        this.label = label;
        this.labelSingular = labelSingular;
        this.symbol = symbol;
        this.category = category;
    }


}
