package com.fssa.blooddonation.enums;

import java.util.Arrays;
import java.util.List;

public enum DonorDistrict {
    CHENNAI("Chennai"),
    COIMBATORE("Coimbatore"),
    MADURAI("Madurai"),
    SALEM("Salem"),
    TRICHY("Tiruchirapalli"),
    ERODE("Erode"),
    VELLORE("Vellore"),
    THANJAVUR("Thanjavur"),
    TIRUNELVELI("Tirunelveli"),
    TIRUPPUR("Tiruppur"),
    TUTICORIN("Thoothukudi"),
    KANCHIPURAM("Kanchipuram"),
    THIRUVALLUR("Thiruvallur"),
    NAMAKKAL("Namakkal"),
    VIRUDHUNAGAR("Virudhunagar"),
    DHARMAPURI("Dharmapuri"),
    CUDDALORE("Cuddalore"),
    KARUR("Karur"),
    RAMANATHAPURAM("Ramanathapuram"),
    SIVAGANGA("Sivaganga"),
    PERAMBALUR("Perambalur"),
    NILGIRIS("The Nilgiris"),
    ARIYALUR("Ariyalur");

    private final String districtName;

    DonorDistrict(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public static List<DonorDistrict> getAllDistricts() {
        return Arrays.asList(DonorDistrict.values());
    }
}
