/*
 * Copyright (C) 2020 Fatih Giris. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fatih.livedatawithflowsample.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.zhang.firstcode.R
import dagger.hilt.android.AndroidEntryPoint
import io.fatih.livedatawithflowsample.MainViewModel
import io.fatih.livedatawithflowsample.data.theme.Theme
import kotlinx.android.synthetic.main.fragment_main.*

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnWeatherForecast.setOnClickListener {
            // Weather forecast with one shot request
            findNavController().navigate(R.id.action_mainFragment_to_weatherForecastOneShotFragment)
        }

        btnWeatherForecastRealTimeLiveData.setOnClickListener {
            // Weather forecast with using Live data & Flow (data stream)
            findNavController().navigate(R.id.action_mainFragment_to_weatherForecastDataStreamFragment)
        }

        btnWeatherForecastRealTimeFlow.setOnClickListener {
            // Weather forecast with using only Flow (data stream)
            findNavController().navigate(R.id.action_mainFragment_to_weatherForecastDataStreamFlowFragment)
        }

        btnDarkMode.setOnClickListener {
            // Enable dark mode
            viewModel.setTheme(Theme.DARK)
        }

        btnFilterCities.setOnClickListener {
            // Filter city list with using Flow and Channel
            findNavController().navigate(R.id.action_mainFragment_to_searchCityFragment)
        }
    }
}