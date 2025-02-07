/*******************************************************************************
 * # License
 * Copyright 2020 Silicon Laboratories Inc. www.silabs.com
 *******************************************************************************
 *
 * The licensor of this software is Silicon Laboratories Inc. Your use of this
 * software is governed by the terms of Silicon Labs Master Software License
 * Agreement (MSLA) available at
 * www.silabs.com/about-us/legal/master-software-license-agreement. This
 * software is distributed to you in Source Code format and is governed by the
 * sections of the MSLA applicable to Source Code.
 *
 ******************************************************************************/

package com.silabs.pti.format;

/**
 * Supported file formats.
 *
 * Created on Feb 15, 2017
 *
 * @author timotej
 */
public enum FileFormat {
  DUMP(new DumpFileFormat()),
  RAW(new RawFileFormat()),
  LOG(new LogFileFormat()),
  AEM(new AemFileFormat()),
  TEXT(new TextFileFormat()),
  PCAPNG(new PcapngFormat(PcapngFormat.Mode.DCH)),
  PCAPNG_MATTER(new PcapngFormat(PcapngFormat.Mode.MATTER)),
  PCAPNG_ZIGBEE(new PcapngFormat(PcapngFormat.Mode.ZIGBEE)),
  PCAPNG_WISUN(new PcapngFormat(PcapngFormat.Mode.WISUN)),
  PCAPNG_BLE(new PcapngFormat(PcapngFormat.Mode.BLUETOOTH)),
  ;

  private IDebugChannelExportFormat<?> format;

  private FileFormat(final IDebugChannelExportFormat<?> format) {
    this.format = format;
  }

  /**
   * Returns the underlying format implementation.
   *
   * @return IPtiFileFormat implementation.
   */
  public IDebugChannelExportFormat<?> format() {
    return format;
  }

  /**
   * returns formats as f1|f2|f3 to show in options.
   *
   * @return
   */
  public static String displayOptionsAsString() {
    final StringBuilder formats = new StringBuilder();
    String sep = "";
    for (final FileFormat ff : FileFormat.values()) {
      formats.append(sep).append(ff.name().toLowerCase());
      sep = "|";
    }
    return formats.toString();
  }

}
