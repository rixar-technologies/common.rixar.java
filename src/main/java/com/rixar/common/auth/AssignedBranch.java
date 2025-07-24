package com.rixar.common.auth;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * Creation Date: Mon 27, Nov 2023 <br/>
 * Creation Time: 10:09<br/>
 * Project: EYASI-TECHNOLOGIES <br/>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssignedBranch implements Serializable {

    Long branchId;

    // Currently not populated the branches column on sessions table would be too wide
    List<String> permissionNames;

}