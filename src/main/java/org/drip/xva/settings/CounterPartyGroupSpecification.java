
package org.drip.xva.settings;

/*
 * -*- mode: java; tab-width: 4; indent-tabs-mode: nil; c-basic-offset: 4 -*-
 */

/*!
 * Copyright (C) 2017 Lakshmi Krishnamurthy
 * 
 *  This file is part of DRIP, a free-software/open-source library for buy/side financial/trading model
 *  	libraries targeting analysts and developers
 *  	https://lakshmidrip.github.io/DRIP/
 *  
 *  DRIP is composed of four main libraries:
 *  
 *  - DRIP Fixed Income - https://lakshmidrip.github.io/DRIP-Fixed-Income/
 *  - DRIP Asset Allocation - https://lakshmidrip.github.io/DRIP-Asset-Allocation/
 *  - DRIP Numerical Optimizer - https://lakshmidrip.github.io/DRIP-Numerical-Optimizer/
 *  - DRIP Statistical Learning - https://lakshmidrip.github.io/DRIP-Statistical-Learning/
 * 
 *  - DRIP Fixed Income: Library for Instrument/Trading Conventions, Treasury Futures/Options,
 *  	Funding/Forward/Overnight Curves, Multi-Curve Construction/Valuation, Collateral Valuation and XVA
 *  	Metric Generation, Calibration and Hedge Attributions, Statistical Curve Construction, Bond RV
 *  	Metrics, Stochastic Evolution and Option Pricing, Interest Rate Dynamics and Option Pricing, LMM
 *  	Extensions/Calibrations/Greeks, Algorithmic Differentiation, and Asset Backed Models and Analytics.
 * 
 *  - DRIP Asset Allocation: Library for model libraries for MPT framework, Black Litterman Strategy
 *  	Incorporator, Holdings Constraint, and Transaction Costs.
 * 
 *  - DRIP Numerical Optimizer: Library for Numerical Optimization and Spline Functionality.
 * 
 *  - DRIP Statistical Learning: Library for Statistical Evaluation and Machine Learning.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *   	you may not use this file except in compliance with the License.
 *   
 *  You may obtain a copy of the License at
 *  	http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing, software
 *  	distributed under the License is distributed on an "AS IS" BASIS,
 *  	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  
 *  See the License for the specific language governing permissions and
 *  	limitations under the License.
 */

/**
 * CounterPartyGroupSpecification contains the Specifications of a Counter Party Group. The References are:
 *  
 *  - Burgard, C., and M. Kjaer (2014): PDE Representations of Derivatives with Bilateral Counter-party Risk
 *  	and Funding Costs, Journal of Credit Risk, 7 (3) 1-19.
 *  
 *  - Burgard, C., and M. Kjaer (2014): In the Balance, Risk, 24 (11) 72-75.
 *  
 *  - Gregory, J. (2009): Being Two-faced over Counter-party Credit Risk, Risk 20 (2) 86-90.
 *  
 *  - Li, B., and Y. Tang (2007): Quantitative Analysis, Derivatives Modeling, and Trading Strategies in the
 *  	Presence of Counter-party Credit Risk for the Fixed Income Market, World Scientific Publishing,
 *  	Singapore.
 * 
 *  - Piterbarg, V. (2010): Funding Beyond Discounting: Collateral Agreements and Derivatives Pricing, Risk
 *  	21 (2) 97-102.
 * 
 * @author Lakshmi Krishnamurthy
 */

public class CounterPartyGroupSpecification {
	private int _iBankDefaultWindow = -1;
	private java.lang.String _strID = "";
	private java.lang.String _strName = "";
	private int _iCounterPartyDefaultWindow = -1;
	private org.drip.xva.settings.MarginPeriodOfRisk _mpor = null;

	/**
	 * Construct a Standard Instance of CounterPartyGroupSpecification
	 * 
	 * @param strName The Collateral Group Name
	 * 
	 * @return The Standard Instance of CounterPartyGroupSpecification
	 */

	public static final CounterPartyGroupSpecification Standard (
		final java.lang.String strName)
	{
		try {
			return new CounterPartyGroupSpecification (org.drip.quant.common.StringUtil.GUID(), strName,
				org.drip.xva.settings.MarginPeriodOfRisk.Standard(), 14, 14);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * CounterPartyGroup Constructor
	 * 
	 * @param strID The Collateral Group ID
	 * @param strName The Collateral Group Name
	 * @param mpor The Margin Period Of Risk
	 * @param iCounterPartyDefaultWindow The Counter Party Default Window
	 * @param iBankDefaultWindow The Bank Default Window
	 * 
	 * @throws java.lang.Exception Thrown if the Inputs are Invalid
	 */

	public CounterPartyGroupSpecification (
		final java.lang.String strID,
		final java.lang.String strName,
		final org.drip.xva.settings.MarginPeriodOfRisk mpor,
		final int iCounterPartyDefaultWindow,
		final int iBankDefaultWindow)
		throws java.lang.Exception
	{
		if (null == (_strID = strID) || _strID.isEmpty() || null == (_strName = strName) ||
			_strName.isEmpty() || null == (_mpor = mpor) || -1 >= (_iCounterPartyDefaultWindow =
				iCounterPartyDefaultWindow) || -1 >= (_iBankDefaultWindow = iBankDefaultWindow))
			throw new java.lang.Exception ("CounterPartyGroupSpecification Constructor => Invalid Inputs");
	}

	/**
	 * Retrieve the Collateral Group ID
	 * 
	 * @return The Collateral Group ID
	 */

	public java.lang.String id()
	{
		return _strID;
	}

	/**
	 * Retrieve the Collateral Group Name
	 * 
	 * @return The Collateral Group Name
	 */

	public java.lang.String name()
	{
		return _strName;
	}

	/**
	 * Retrieve the Margin Period Of Risk
	 * 
	 * @return The Margin Period Of Risk
	 */

	public org.drip.xva.settings.MarginPeriodOfRisk mpor()
	{
		return _mpor;
	}

	/**
	 * Retrieve the Counter Party Default Window
	 * 
	 * @return The Counter Party Default Window
	 */

	public int counterPartyDefaultWindow()
	{
		return _iCounterPartyDefaultWindow;
	}

	/**
	 * Retrieve the Bank Default Window
	 * 
	 * @return The Bank Default Window
	 */

	public int bankDefaultWindow()
	{
		return _iBankDefaultWindow;
	}
}
