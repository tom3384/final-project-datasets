// Tom Nguyen
// 11/29/24
// CPSC 39 project
// Getters and setters and constructor 

// provider_location_guid	loc_store_no	loc_phone	loc_name	loc_admin_street1	loc_admin_street2	loc_admin_city	loc_admin_state	loc_admin_zip	sunday_hours	monday_hours	tuesday_hours	wednesday_hours	thursday_hours	friday_hours	saturday_hours	web_address	pre_screen	insurance_accepted	walkins_accepted	provider_notes	ndc	med_name	in_stock	supply_level	quantity_last_updated	latitude	longitude	Category	Unnamed Column	offers_free_masks	min_age_months	min_age_years	bridge_access_program


public class VaccineProviderInfo {
    private String providerLocationGuid;
    private String locStoreNo;
    private String locPhone;
    private String locName;
    private String locAdminStreet1;
    private String locAdminStreet2;
    private String locAdminCity;
    private String locAdminState;
    private String locAdminZip;
    private String sundayHours;
    private String mondayHours;
    private String tuesdayHours;
    private String wednesdayHours;
    private String thursdayHours;
    private String fridayHours;
    private String saturdayHours;
    private String webAddress;
    private String preScreen;
    private String insuranceAccepted;
    private String walkinsAccepted;
    private String providerNotes;
    private String ndc;
    private String medName;
    private boolean inStock;
    private String supplyLevel;
    private String quantityLastUpdated;
    private double latitude;
    private double longitude;
    private String category;
    private String unnamedColumn;
    private boolean offersFreeMasks;
    private int minAgeMonths;
    private int minAgeYears;
    private boolean bridgeAccessProgram;

    // Constructor
    public VaccineProviderInfo(String providerLocationGuid, String locStoreNo, String locPhone, String locName,
                        String locAdminStreet1, String locAdminStreet2, String locAdminCity, String locAdminState,
                        String locAdminZip, String sundayHours, String mondayHours, String tuesdayHours,
                        String wednesdayHours, String thursdayHours, String fridayHours, String saturdayHours,
                        String webAddress, String preScreen, String insuranceAccepted, String walkinsAccepted,
                        String providerNotes, String ndc, String medName, boolean inStock, String supplyLevel,
                        String quantityLastUpdated, double latitude, double longitude, String category,
                        String unnamedColumn, boolean offersFreeMasks, int minAgeMonths, int minAgeYears,
                        boolean bridgeAccessProgram) {
        this.providerLocationGuid = providerLocationGuid;
        this.locStoreNo = locStoreNo;
        this.locPhone = locPhone;
        this.locName = locName;
        this.locAdminStreet1 = locAdminStreet1;
        this.locAdminStreet2 = locAdminStreet2;
        this.locAdminCity = locAdminCity;
        this.locAdminState = locAdminState;
        this.locAdminZip = locAdminZip;
        this.sundayHours = sundayHours;
        this.mondayHours = mondayHours;
        this.tuesdayHours = tuesdayHours;
        this.wednesdayHours = wednesdayHours;
        this.thursdayHours = thursdayHours;
        this.fridayHours = fridayHours;
        this.saturdayHours = saturdayHours;
        this.webAddress = webAddress;
        this.preScreen = preScreen;
        this.insuranceAccepted = insuranceAccepted;
        this.walkinsAccepted = walkinsAccepted;
        this.providerNotes = providerNotes;
        this.ndc = ndc;
        this.medName = medName;
        this.inStock = inStock;
        this.supplyLevel = supplyLevel;
        this.quantityLastUpdated = quantityLastUpdated;
        this.latitude = latitude; //26 (zero indexed)
        this.longitude = longitude; //27
        this.category = category; //28
        this.unnamedColumn = unnamedColumn; //29
        this.offersFreeMasks = offersFreeMasks; //30
        this.minAgeMonths = minAgeMonths; //31 
        this.minAgeYears = minAgeYears; //32 
        this.bridgeAccessProgram = bridgeAccessProgram; //33
    }

    // Getters and Setters
    public String getProviderLocationGuid() {
        return providerLocationGuid;
    }

    public void setProviderLocationGuid(String providerLocationGuid) {
        this.providerLocationGuid = providerLocationGuid;
    }

    public String getLocStoreNo() {
        return locStoreNo;
    }

    public void setLocStoreNo(String locStoreNo) {
        this.locStoreNo = locStoreNo;
    }

    public String getLocPhone() {
        return locPhone;
    }

    public void setLocPhone(String locPhone) {
        this.locPhone = locPhone;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public String getLocAdminStreet1() {
        return locAdminStreet1;
    }

    public void setLocAdminStreet1(String locAdminStreet1) {
        this.locAdminStreet1 = locAdminStreet1;
    }

    public String getLocAdminStreet2() {
        return locAdminStreet2;
    }

    public void setLocAdminStreet2(String locAdminStreet2) {
        this.locAdminStreet2 = locAdminStreet2;
    }

    public String getLocAdminCity() {
        return locAdminCity;
    }

    public void setLocAdminCity(String locAdminCity) {
        this.locAdminCity = locAdminCity;
    }

    public String getLocAdminState() {
        return locAdminState;
    }

    public void setLocAdminState(String locAdminState) {
        this.locAdminState = locAdminState;
    }

    public String getLocAdminZip() {
        return locAdminZip;
    }

    public void setLocAdminZip(String locAdminZip) {
        this.locAdminZip = locAdminZip;
    }

    public String getSundayHours() {
        return sundayHours;
    }

    public void setSundayHours(String sundayHours) {
        this.sundayHours = sundayHours;
    }

    public String getMondayHours() {
        return mondayHours;
    }

    public void setMondayHours(String mondayHours) {
        this.mondayHours = mondayHours;
    }

    public String getTuesdayHours() {
        return tuesdayHours;
    }

    public void setTuesdayHours(String tuesdayHours) {
        this.tuesdayHours = tuesdayHours;
    }

    public String getWednesdayHours() {
        return wednesdayHours;
    }

    public void setWednesdayHours(String wednesdayHours) {
        this.wednesdayHours = wednesdayHours;
    }

    public String getThursdayHours() {
        return thursdayHours;
    }

    public void setThursdayHours(String thursdayHours) {
        this.thursdayHours = thursdayHours;
    }

    public String getFridayHours() {
        return fridayHours;
    }

    public void setFridayHours(String fridayHours) {
        this.fridayHours = fridayHours;
    }

    public String getSaturdayHours() {
        return saturdayHours;
    }

    public void setSaturdayHours(String saturdayHours) {
        this.saturdayHours = saturdayHours;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getPreScreen() {
        return preScreen;
    }

    public void setPreScreen(String preScreen) {
        this.preScreen = preScreen;
    }

    public String getInsuranceAccepted() {
        return insuranceAccepted;
    }

    public void setInsuranceAccepted(String insuranceAccepted) {
        this.insuranceAccepted = insuranceAccepted;
    }

    public String getWalkinsAccepted() {
        return walkinsAccepted;
    }

    public void setWalkinsAccepted(String walkinsAccepted) {
        this.walkinsAccepted = walkinsAccepted;
    }

    public String getProviderNotes() {
        return providerNotes;
    }

    public void setProviderNotes(String providerNotes) {
        this.providerNotes = providerNotes;
    }

    public String getNdc() {
        return ndc;
    }

    public void setNdc(String ndc) {
        this.ndc = ndc;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public String getSupplyLevel() {
        return supplyLevel;
    }

    public void setSupplyLevel(String supplyLevel) {
        this.supplyLevel = supplyLevel;
    }

    public String getQuantityLastUpdated() {
        return quantityLastUpdated;
    }

    public void setQuantityLastUpdated(String quantityLastUpdated) {
        this.quantityLastUpdated = quantityLastUpdated;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnnamedColumn() {
        return unnamedColumn;
    }

    public void setUnnamedColumn(String unnamedColumn) {
        this.unnamedColumn = unnamedColumn;
    }

    public boolean isOffersFreeMasks() {
        return offersFreeMasks;
    }

    public void setOffersFreeMasks(boolean offersFreeMasks) {
        this.offersFreeMasks = offersFreeMasks;
    }

    public int getMinAgeMonths() {
        return minAgeMonths;
    }

    public void setMinAgeMonths(int minAgeMonths) {
        this.minAgeMonths = minAgeMonths;
    }

    public int getMinAgeYears() {
        return minAgeYears;
    }

    public void setMinAgeYears(int minAgeYears) {
        this.minAgeYears = minAgeYears;
    }

    public boolean isBridgeAccessProgram() {
        return bridgeAccessProgram;
    } 

}